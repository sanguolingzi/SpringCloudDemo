package demo.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class TestTopicConsumer {

    private static final Logger logger = LoggerFactory.getLogger(TestTopicConsumer.class);

    @JmsListener(destination = "testPersistTopic",containerFactory = "jmsListenerContainerFactoryForOrderTestTopic")
    public void doBusiness(Session session, TextMessage message){
        String messageId = null;
        try{
            messageId=message.getJMSMessageID();
            logger.info("已收到testTopic消息:"+messageId);
        }catch (Exception e){
            //发生异常需要记录信息内容 消息仍然被消费掉
            logger.error(messageId+"异常testTopic",e.getMessage());
        }
    }
}
