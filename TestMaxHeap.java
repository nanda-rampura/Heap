package heap;
import java.util.ArrayList;

public class TestMaxHeap
{	
	public static void main(String args[])
	{
		int length = 10;
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		for(int i = 0; i < length; i++)
		{		
			inputList.add((int)(Math.random()*100));
		}
		
		MaxHeap heap = new MaxHeap();
		System.out.println("Original data:");
		heap.printData(inputList);
		
		heap.heapSort(inputList);
		System.out.println("After sorting heap");
		heap.printData(inputList);
		
		System.out.println("Priority queue (higher value->higher priority) using max-heap:");
		PriorityQueue queue = new PriorityQueue();
		System.out.println("Adding 20 and 10");
		queue.insert(20);
		queue.insert(10);
		queue.printData();

		System.out.println("Peeking the front of the queue:");
		System.out.println("Value at front = " + queue.getMax());
		System.out.println("");
		
		System.out.println("Adding 30 to queue:");
		queue.insert(30);
		queue.printData();
		
		System.out.println("Extracting the front of the queue:");
		System.out.println("Extracted value = " + queue.extractMax());
		queue.printData();
	}
}