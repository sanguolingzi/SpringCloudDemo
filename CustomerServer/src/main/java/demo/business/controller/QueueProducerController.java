package demo.business.controller;

import demo.business.httpresponse.ResponseData;
import demo.config.MessageTemplate;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseDataUtil;

import javax.jms.*;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("queue")
public class QueueProducerController {

    private static final Logger logger = LoggerFactory.getLogger(QueueProducerController.class);

    @Autowired
    private JmsTemplate myJmsTemplate;

    @Autowired
    private JmsTemplate persistantJmsTemplate;

    @Autowired
    private Destination testQueue;

    @Autowired
    private Destination testPersistQueue;

    @Autowired
    private MessageTemplate messageTemplate;

    @GetMapping(value="sendMessage")
    public ResponseData<Object> sendMessage(){
        //myJmsTemplate.convertAndSend(testQueue,"123456+"+System.currentTimeMillis());
        LocalDateTime localDateTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        String messageId = UUID.randomUUID().toString();
        try{
            sb.append(localDateTime.getHour()).append(":").append(localDateTime.getMinute())
                    .append(":").append(localDateTime.getSecond());

            logger.info(messageId+"开始发送!"+sb.toString());
            myJmsTemplate.send(testQueue, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage = session.createTextMessage("testQueue+..."+System.currentTimeMillis());
                    textMessage.setJMSMessageID(messageId);
                    return textMessage;
                }
            });
            logger.info(messageId+"发送成功!");
        }catch (Exception e){
            localDateTime = LocalDateTime.now();
            sb.setLength(0);
            sb.append(localDateTime.getHour()).append(":").append(localDateTime.getMinute())
                    .append(":").append(localDateTime.getSecond());
            logger.error(messageId+"catch 出现异常!"+sb.toString()+"error:"+e.getMessage());
        }

        return ResponseDataUtil.toSuccess();
    }


    @GetMapping(value="sendPersistMessage")
    public ResponseData<Object> sendPersistMessage(){
        persistantJmsTemplate.send(testPersistQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("testPersistQueue+"+System.currentTimeMillis());
                /*//尝试延迟投递
                long delay = 30 * 1000;
                long period = 10 * 1000;
                int repeat = 9;
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
                textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);*/
                return textMessage;
            }
        });
        return ResponseDataUtil.toSuccess();
    }

    @GetMapping(value="sendMessage2")
    public ResponseData<Object> sendMessage2(){
        final ActiveMQTextMessage message = new ActiveMQTextMessage();
        LocalDateTime localDateTime = LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        try{
            sb.append(localDateTime.getHour()).append(":").append(localDateTime.getMinute())
                    .append(":").append(localDateTime.getSecond());
            message.setJMSMessageID(UUID.randomUUID().toString());
            message.setText("sendMessage2"+message.getJMSMessageID());
            logger.info(message.getJMSMessageID()+"开始发送!"+sb.toString());
            messageTemplate.send(message, new AsyncCallback() {
                @Override
                public void onException(JMSException e) {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    StringBuilder sb = new StringBuilder();
                    sb.append(localDateTime.getHour()).append(":").append(localDateTime.getMinute())
                            .append(":").append(localDateTime.getSecond());
                    logger.error(message.getJMSMessageID()+" onException 出现异常!"+sb.toString()+"error:"+e.getMessage());
                }

                @Override
                public void onSuccess() {
                    logger.info(message.getJMSMessageID()+"发送成功!");
                }

            });

        }catch (Exception e){
            localDateTime = LocalDateTime.now();
            sb.setLength(0);
            sb.append(localDateTime.getHour()).append(":").append(localDateTime.getMinute())
                    .append(":").append(localDateTime.getSecond());
            logger.error(message.getJMSMessageID()+" catch 出现异常!"+sb.toString()+"error:"+e.getMessage());
        }
        return ResponseDataUtil.toSuccess();
    }
}
