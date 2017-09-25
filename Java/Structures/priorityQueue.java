import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class priorityQueue {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
		Random rand = new Random();
		for(int i=0;i<7;i++){
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		
		// Priority Queue's iterator is disordered.
		Iterator<Integer> iterator = integerPriorityQueue.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		//Use poll() is order.
		for(int i = 0; i < 7; ++ i){
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing Integer:"+in);
		}
		
		//PriorityQueue example with Comparator
		Queue<TestEntity> customerPriorityQueue = new PriorityQueue<>(7, new Comparator<TestEntity>(){
			@Override
			public int compare(TestEntity t1, TestEntity t2) {
	            return (t2.getId() - t1.getId());
	        }
		});
		Random rd = new Random();
		for(int i = 0; i < 7; ++ i){
			int id = rd.nextInt(100);
			TestEntity cu = new TestEntity(id, "Luke "+id);
			customerPriorityQueue.add(cu);
		}
		pollDataFromQueue(customerPriorityQueue);	
	}
	
	//utility method to poll data from queue
	private static void pollDataFromQueue(Queue<TestEntity> customerPriorityQueue) {
		while(true){
			TestEntity cust = customerPriorityQueue.poll();
			if(cust == null) break;
			System.out.println("Processing Customer with ID="+cust.getId());
		}
	}
}
