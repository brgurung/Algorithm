import java.util.PriorityQueue;

public class TestPriorityQueue {

	public static void main(String[] args)
	{
		PriorityQueue<Double> queue = new PriorityQueue<>();
		
		
		// add data to the queue
		queue.offer(1.2);
		queue.offer(3.1);
		queue.offer(4.5);
		queue.offer(1.0);
		
		System.out.println("Input data in a queue: " + queue);
		
		while (queue.size() > 0)
		{
			System.out.println("Data to be polled: " + queue.peek());
			Double d = queue.poll();
		}
	}
}
