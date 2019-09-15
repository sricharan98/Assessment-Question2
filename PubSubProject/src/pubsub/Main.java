package pubsub;
import pubsub.Publisher;
import pubsub.PubSubService;
import pubsub.Subscriber;

public class Main 
{
	public static void main(String[] args) 
	{
		
		Publisher pub1 = new Publisher();
		Publisher pub2 = new Publisher();
		Subscriber sub1 = new Subscriber();
		Subscriber sub2 = new Subscriber();
		PubSubService pubSubService = new PubSubService();
		
		Message Msg1 = new Message("Topic1", "This is first message under Topic 1");
		Message Msg2 = new Message("Topic1", "This is second message under Topic 1");
		
		pub1.publish(Msg1, pubSubService);
		pub1.publish(Msg2, pubSubService);
		
		Message Msg3 = new Message("Topic2", "This is first message under Topic 2");
		Message Msg4 = new Message("Topic2", "This is second message under Topic 2");
		
		pub2.publish(Msg3, pubSubService);
		pub2.publish(Msg4, pubSubService);
		
		sub1.addSubscriber("Topic1",pubSubService);		
		sub2.addSubscriber("Topic2",pubSubService);  
		
		pubSubService.sendMessages();
		
		System.out.println("Messages of Topic1 Subscriber are: ");
		sub1.printMessages();
		
		System.out.println("\nMessages of Topic2 Subscriber are: ");
		sub2.printMessages();
		
	}
}