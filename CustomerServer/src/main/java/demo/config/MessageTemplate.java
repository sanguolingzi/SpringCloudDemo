package demo.config;

import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;

/**
 * 用来处理使用ActivemqConnectionFactory生成的ActiveMQMessageProducer发送消息
 * 该producer可使用带回调的send方法 在异步发送中可确认消息状态是否发送成功
 */
public class MessageTemplate {

    private ConnectionFactory connectionFactory;

    /**
     * 默认 非事务
     */
    private boolean isTransaction = false;

    /**
     *  默认非持久化
     */
    private int isPersistent = DeliveryMode.NON_PERSISTENT;

    private String name;
    /**
     *  默认topic 否则 queue
     */
    private boolean isTopic = true;

    public MessageTemplate(){

    }


    public boolean isTransaction() {
        return isTransaction;
    }

    public void setTransaction(boolean transaction) {
        isTransaction = transaction;
    }

    public int getIsPersistent() {
        return isPersistent;
    }

    public void setIsPersistent(int isPersistent) {
        this.isPersistent = isPersistent;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTopic() {
        return isTopic;
    }

    public void setTopic(boolean topic) {
        isTopic = topic;
    }

    public boolean send(Message message, AsyncCallback callBack) throws Exception{
        Connection connection = null;
        Destination destination = null;
        Session session = null;
        try{
            connection = connectionFactory.createConnection();
            session = connection.createSession(this.isTransaction,this.isPersistent);
            if(this.isTopic){
                destination =  session.createTopic(this.name);
            }else{
                destination =  session.createQueue(this.name);
            }
            // 创建消息生产者
            //PooledProducer pooledProducer = (PooledProducer)session.createProducer(destination);
            //pooledProducer.send(message,this.isPersistent,0,0L);
            ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer)session.createProducer(destination);
            activeMQMessageProducer.send(message,this.isPersistent,0,0L,callBack);

            if(this.isTransaction)
                session.commit();
            return true;
        }finally {
            if(session != null){
                session.close();
            }

            if(connection != null){
                connection.close();
            }
        }
    }

}
