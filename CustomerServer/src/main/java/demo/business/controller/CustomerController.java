package demo.business.controller;

import demo.business.httpresponse.ResponseData;
import demo.business.service.info.CustomerInfoService;
import model.custoemr.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseDataUtil;

import javax.jms.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerInfoService customerInfoServiceImpl;

    @Autowired
    private JmsTemplate myJmsTemplate;

    @Autowired
    private JmsTemplate persistantJmsTemplate;

    @Autowired
    private Destination testQueue;

    @Autowired
    private Destination testPersistQueue;
    @GetMapping(value="getCustomerInfo")
    public ResponseData<CustomerModel> getCustomerInfoExecutor(@RequestParam("customerId") String customerId){
        return ResponseDataUtil.toSuccess(customerInfoServiceImpl.getCustomerInfo(customerId));
    }


    @GetMapping(value="sendMessage")
    public ResponseData<Object> sendMessage(){
        //myJmsTemplate.convertAndSend(testQueue,"123456+"+System.currentTimeMillis());
        myJmsTemplate.send(testQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("testQueue+..."+System.currentTimeMillis());
            }
        });
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
}
