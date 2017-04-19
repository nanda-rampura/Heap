package heap;
import java.util.ArrayList;

public class PriorityQueue
{
	ArrayList<Integer> inputList;
	MaxHeap heap;
	
	PriorityQueue()
	{
		inputList = new ArrayList<Integer>();
		heap = new MaxHeap();
	}
	
	public void insert(int element)
	{
		heap.insert(inputList, element);
	}
	
	public int getMax()
	{
		if (inputList.isEmpty())
		{
			System.out.println("LIST IS EMPTY!!!");
			return -1;
		}
		
		return inputList.get(0).intValue();
	}
	
	public int extractMax()
	{
		return heap.extractMax(inputList);
	}

	public void printData()
	{
		System.out.print("Queue Elements: ");
		for(int i = 0; i < inputList.size(); i++)
		{
			System.out.print(inputList.get(i).intValue() + " ");
		}
		System.out.println();
		System.out.println();
	}
}