package pubsub;

import pubsub.Message;
import pubsub.PubSubService;

public class Publisher {
	public void publish(Message message, PubSubService pubSubService) {		
		pubSubService.addMessageToQueue(message);
	}
}