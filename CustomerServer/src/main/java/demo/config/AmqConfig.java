package demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.backoff.FixedBackOff;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Session;
import java.util.concurrent.Executors;

@Configuration
//@EnableJms
public class AmqConfig implements JmsListenerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AmqConfig.class);

    @Value("${spring.activemq.broker-url}")
    private String url;

    @Value("${spring.activemq.user}")
    private String userName;

    @Value("${spring.activemq.password}")
    private String password;


    @Value("${customer.activemq.queue.testQueue}")
    private String testQueue;

    @Value("${customer.activemq.queue.testPersistQueue}")
    private String testPersistQueue;

    @Value("${customer.activemq.topic.testPersistTopic}")
    private String testPersistTopic;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar) {

    }

    /**
     * 全局设置
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        //targetConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, url);
        connectionFactory.setUseCompression(true);
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        //设置消息的最大重发次数 超过这个次数  则进入死信队列
        redeliveryPolicy.setMaximumRedeliveries(2);
        //启用指数倍数递增的方式增加延迟时间
        redeliveryPolicy.setUseExponentialBackOff(true);

        //设置重连时间间隔递增倍数，只有值大于1和启用useExponentialBackOff参数时才生效
        redeliveryPolicy.setBackOffMultiplier(2);

        //最大传送延迟，只在useExponentialBackOff为true时有效 达到最大时间后 将以最大时间为 间隔时间重发
        redeliveryPolicy.setMaximumRedeliveryDelay(1000*120);
        //设置初始重发间隔
        redeliveryPolicy.setInitialRedeliveryDelay(5000l);
        connectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        //异步发送消息
        connectionFactory.setAlwaysSyncSend(true);
        connectionFactory.setProducerWindowSize(1024);
        connectionFactory.setSendTimeout(2000);
        //设置预获取属性设置
        ActiveMQPrefetchPolicy activeMQPrefetchPolicy = new ActiveMQPrefetchPolicy();
        activeMQPrefetchPolicy.setQueuePrefetch(50);
        connectionFactory.setPrefetchPolicy(activeMQPrefetchPolicy);

        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setMaxConnections(20);
        //pooledConnectionFactory.setMaximumActiveSessionPerConnection(5);
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        return pooledConnectionFactory;
    }
    /**
     * 控制 jmslistener连接
     * @param connectionFactory
     * @return
     */
    @Bean("jmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory,
             DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置消息确认模式 这里设置的是单条消息确认 由于和spring集成 用client确认模式 会被spring自动确认
        factory.setSessionAcknowledgeMode(4);
        //设置连接数
        //factory.setConcurrency("2-5");
        //设置backoff 重连设置 这是重连间隔  重连总次数
        FixedBackOff fixedBackOff = new FixedBackOff(5000l, 10);
        factory.setBackOff(fixedBackOff);

        //设置线程池 原有线程没有做到复用
        factory.setTaskExecutor(Executors.newFixedThreadPool(20));
        //每个任务最大的任务数目
        //factory.setMaxMessagesPerTask(1);

        //设置信息
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    @Bean("testQueue")
    public Destination testQueue(){
        ActiveMQQueue queue = new ActiveMQQueue(testQueue);
        return queue;
    }
    @Bean("testPersistQueue")
    public Destination testPersistQueue(){
        ActiveMQQueue queue = new ActiveMQQueue(testPersistQueue);
        return queue;
    }

    @Bean("testPersistTopic")
    public Destination testPersistTopic(){
        ActiveMQTopic topic = new ActiveMQTopic(testPersistTopic);
        return topic;
    }



    @Bean("myJmsTemplate")
    public JmsTemplate myJmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate myJmsTemplate = new JmsTemplate(connectionFactory);
        /*
        如果不打开服务质量的开关，消息的递送模式、优先级和存活时间的设置就没有作用。
        Class org.springframework.jms.core.JmsTemplate
        public void setExplicitQosEnabled(boolean explicitQosEnabled)
        发送消息的时候，是否使用QOS的值（deliveryMode, priority, timeToLive）
        */
        myJmsTemplate.setExplicitQosEnabled(true);
        //设置事务模式
        myJmsTemplate.setSessionTransacted(false);
        //设置消息过期时间
        //myJmsTemplate.setTimeToLive(20);

        //设置消息确认机制
        myJmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        /*
        public void setDeliveryMode(int deliveryMode)
        设置是否持久化要发送的消息：1-非持久化；2-持久化
        public void setDeliveryPersistent(boolean deliveryPersistent)
        设置是否持久化要发送的消息，true-持久化；false-非持久化
        */
        myJmsTemplate.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        return myJmsTemplate;
    }


    /**
     * 持久化消息
     * @param connectionFactory
     * @return
     */
    @Bean("persistantJmsTemplate")
    public JmsTemplate persistantJmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate persistantJmsTemplate = new JmsTemplate(connectionFactory);
        persistantJmsTemplate.setExplicitQosEnabled(true);
        persistantJmsTemplate.setSessionTransacted(true);
        persistantJmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        persistantJmsTemplate.setTimeToLive(15000);
        return persistantJmsTemplate;
    }

    /**
     * topic持久化消息
     * @param connectionFactory
     * @return
     */
    @Bean("topicPersistantJmsTemplate")
    public JmsTemplate topicPersistantJmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate persistantJmsTemplate = new JmsTemplate(connectionFactory);
        persistantJmsTemplate.setExplicitQosEnabled(true);
        persistantJmsTemplate.setSessionTransacted(true);
        persistantJmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        //persistantJmsTemplate.setTimeToLive(15000);
        return persistantJmsTemplate;
    }


    @Bean
    public MessageTemplate messageTemplate(ConnectionFactory connectionFactory){
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setConnectionFactory(connectionFactory);
        messageTemplate.setName(testQueue);
        messageTemplate.setTopic(false);
        return messageTemplate;
    }



}
