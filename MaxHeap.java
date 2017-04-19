package heap;
import java.util.ArrayList;

public class MaxHeap
{
	public void buildMaxHeap(ArrayList<Integer> input)
	{
		for(int i = (input.size()/2)-1; i >= 0; i--)
		{
//			maxHeapifyIterative(input, i);
			maxHeapifyRecursive(input, i);
		}
	}
	
	public void heapSort(ArrayList<Integer> input)	
	{
		buildMaxHeap(input);
		System.out.println("After building max-heap");
		printData(input);
		
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		while(input.size() > 0)
		{
			sortedList.add(input.get(0));
			input.set(0, input.get(input.size()-1));
			input.remove(input.size()-1);
//			maxHeapifyIterative(input, 0);
			maxHeapifyRecursive(input, 0);
		}
		input.addAll(sortedList);
	}
	
	public void insert(ArrayList<Integer> input, int element)
	{
		input.add(input.size(), element);
		insertMaxHeapify(input, (input.size()-1));
	}
	
	public int extractMax(ArrayList<Integer> input)
	{
		int returnValue = -1;
		if (input.isEmpty())
		{
			System.out.println("LIST IS EMPTY!!!");
			return returnValue;
		}
		
		returnValue = input.get(0).intValue();
		input.set(0, input.get(input.size()-1));
		input.remove(input.size()-1);
		maxHeapifyRecursive(input, 0);
		return returnValue;	
	}
		
	public void printData(ArrayList<Integer> input)
	{
		for(int i = 0; i < input.size(); i++ )
		{
			System.out.print(input.get(i).intValue()+" ");
		}
		System.out.println();
		System.out.println();
	}

	private void maxHeapifyIterative(ArrayList<Integer> input, int index)
	{
		while(true)
		{
			int left = 2*index+1;
			int right = 2*index+2;
			int candidate = left;
			
			// Return when max heapify is called on leaf node
			if(left >= input.size())
			{
				break;
			}
			
			if(right < input.size() && (input.get(left).intValue()) < (input.get(right).intValue()))
			{
				candidate = right;
			}
			
			if(input.get(index).intValue() < input.get(candidate).intValue())
			{
				swap(input, index, candidate);
				index = candidate;
			}
			else
			{
				break;
			}
		}
	}
	
	private void maxHeapifyRecursive(ArrayList<Integer> input, int index)
	{	
		int left = (2 * index) + 1;
		int right = (2 * index) + 2;
		int candidate = left;
		
		// Return when max heapify is called on leaf node
		if(candidate >= input.size())
		{
			return;
		}
		
		if(right < input.size() && (input.get(left).intValue()) < (input.get(right).intValue()))
		{
			candidate = right;
		}
		if((input.get(index).intValue()) < (input.get(candidate).intValue()))
		{
			swap(input, index, candidate);
			maxHeapifyRecursive(input, candidate);
		}
	}
	
	private void swap(ArrayList<Integer> input, int i, int j)
	{
		int temp;
		temp = input.get(i).intValue();
		input.set(i, input.get(j).intValue());
		input.set(j, temp);
	}
	
	private void insertMaxHeapify(ArrayList<Integer> input, int index)
	{
		if(index == 0)
		{
			return;
		}
		
		int root = (index - 1) / 2;
		if(input.get(root).intValue() < input.get(index).intValue())
		{
			swap(input, root, index);
			insertMaxHeapify(input, root);
		}		
	}
}