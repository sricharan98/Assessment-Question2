package pubsub;

import java.util.ArrayList;
import java.util.List;
import pubsub.Message;
import pubsub.PubSubService;
 
public class Subscriber {	

	private List<Message> subscriberMessages = new ArrayList<Message>();
	
	public List<Message> getSubscriberMessages()
	{
		return subscriberMessages;
	}
	public void setSubscriberMessages(List<Message> subscriberMessages)
	{
		this.subscriberMessages = subscriberMessages;
	}

	public void addSubscriber(String topic, PubSubService pubSubService)
	{
		pubSubService.addSubscriber(topic, this);
	}
	
	public void unSubscribe(String topic, PubSubService pubSubService)
	{
		pubSubService.removeSubscriber(topic, this);
	}
 
	public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService)
	{
		pubSubService.getMessagesForSubscriberOfTopic(topic, this);
		
	}	

	public void printMessages()
	{
		for(Message message : subscriberMessages)
		{
			System.out.println("Message from "+ message.getTopic() + " : " + message.getText());
		}
	}
}