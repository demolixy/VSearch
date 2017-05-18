/**
 * 
 */
package com.thunisoft.vsearch.spider.parse.message;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author lixiangyang
 *
 */
public class TLender {

    private TopicConnection connection = null;
    
    private TopicSession session = null;
    
    private Topic topic;
    
    /**
     * 
     * @param topiccf
     * @param topicname
     * @throws NamingException 
     * @throws JMSException 
     */
    public TLender(String topiccf, String topicname) throws NamingException, JMSException {
        Context ctx = new InitialContext();
        TopicConnectionFactory qFactory = (TopicConnectionFactory) ctx.lookup(topiccf);
        connection = qFactory.createTopicConnection();
        session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        topic = (Topic) ctx.lookup(topicname);
        connection.start();
    }
    
    /**
     * 
     * @param newRate
     * @throws JMSException 
     */
    private void publishRate(double newRate) throws JMSException {
        BytesMessage message = session.createBytesMessage();
        message.writeDouble(newRate);
        TopicPublisher publisher = session.createPublisher(topic);
        publisher.publish(message);
    }
    
    public static void main(String[] args) throws NamingException, JMSException {
        TLender lender = new TLender("", "");
        lender.publishRate(2.00d);
    }
    
    
}
