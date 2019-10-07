package demo.business.activemq.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class TestPersistQueueConsumer/* implements SessionAwareMessageListener*/{

    private static final Logger logger = LoggerFactory.getLogger(TestPersistQueueConsumer.class);

    @JmsListener(destination = "testPersistQueue",containerFactory = "jmsListenerContainerFactory",concurrency="5")
    public void doBusiness(Session session, TextMessage message) throws JMSException{
        try{
            logger.info("已收到消息:"+message);
        }catch (Exception e){
            //发生异常需要记录信息内容 达到重发次数设置后会进入死信队列
            //session.rollback();//mq重启才会重新发送
            session.recover();//立即重新发送
        }
    }
}
