package demo.business.activemq.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class TestQueueConsumer {

    private static final Logger logger = LoggerFactory.getLogger(TestQueueConsumer.class);

    @JmsListener(destination = "testQueue",containerFactory = "jmsListenerContainerFactory",concurrency="5")
    public void doBusiness(Session session, TextMessage message){
        try{
            logger.info("已收到消息:"+message);
        }catch (Exception e){
            //发生异常需要记录信息内容 消息仍然被消费掉
        }
    }
}
