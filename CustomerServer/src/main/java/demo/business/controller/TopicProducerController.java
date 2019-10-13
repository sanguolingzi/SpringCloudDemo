package demo.business.controller;

import demo.business.httpresponse.ResponseData;
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

@RestController
@RequestMapping("topic")
public class TopicProducerController {
    private static final Logger logger = LoggerFactory.getLogger(TopicProducerController.class);


    @Autowired
    private JmsTemplate topicPersistantJmsTemplate;

    @Autowired
    private Destination testPersistTopic;

    @GetMapping(value="sendPersistMessage")
    public ResponseData<Object> sendPersistMessage(){
        topicPersistantJmsTemplate.send(testPersistTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("testPersistTopic+"+System.currentTimeMillis());
                return textMessage;
            }
        });
        return ResponseDataUtil.toSuccess();
    }

}
