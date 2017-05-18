/**
 * 
 */
package com.thunisoft.vsearch.spider.parse.message;

import java.io.Serializable;
import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * @author lixiangyang
 *
 */
public class Chat implements MessageListener {

    private static final Properties prop = new Properties();
    static {
        prop.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        prop.setProperty(Context.PROVIDER_URL,"tcp://172.16.193.61:61616");
        prop.setProperty(Context.SECURITY_PRINCIPAL,"admin");
        prop.setProperty(Context.SECURITY_CREDENTIALS,"admin");
        prop.setProperty("connectionFactoryNames", "TopicCF");
        prop.setProperty("topic.topic1", "jms.topic1");
        
    }
    
    
    private TopicSession pubSession;
    
    private TopicPublisher publisher;
    
    private TopicConnection connection;
    
    
    public Chat() throws NamingException, JMSException {
        Context text = new InitialContext(prop);
        TopicConnectionFactory connectionFactory = (TopicConnectionFactory) text.lookup("TopicCF");
        connection = connectionFactory.createTopicConnection();
        pubSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        TopicSession subSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Topic topic = (Topic) text.lookup("topic1");

        publisher = pubSession.createPublisher(topic);
        TopicSubscriber subscriber = subSession.createSubscriber(topic, null, true);
        
        subscriber.setMessageListener(this);
        
        connection.start();
        
    }
    
    protected void writeMessage() throws JMSException {
        TextMessage text = pubSession.createTextMessage("hahah");
        MyObj obj = new MyObj("lixy", 1);
        ObjectMessage object = pubSession.createObjectMessage(obj);
        publisher.publish(object);
//        publisher.publish(text);
    }
    
    public static void main(String[] args) throws NamingException, JMSException {
        Chat chat = new Chat();
        chat.writeMessage();
    }
    
    
    /* (non-Javadoc)
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(Message message) {
//        TextMessage text = (TextMessage) message;
        try {
//            System.out.println(text.getClass());
//            System.out.println(text.getText());
            ObjectMessage objMes = (ObjectMessage) message;
            System.out.println(objMes.getObject().toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}

class MyObj implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    private Integer num;

    public MyObj(String name, Integer num) {
        this.name = name;
        this.num = num;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}


