/**
	A class implementing an ADT QUEUE using a single linked node
	@author Drue Hidalgo
*/

public class SLDeque<T> implements DequeInterface<T>
{
	private SLNode<T> front; 
	private SLNode<T> back; 
   
	public SLDeque()
	{
		front = null;
		back = null;
	}
	
	public SLDeque(SLNode<T> firstNode)
	{
		front = firstNode;
		back = firstNode;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
		@param newEntry  An object to be added. */
	public void addToFront(T newEntry)
	{
		SLNode<T> newNode = new SLNode<T>(newEntry);
		if (front == null)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			front.setPrev(newNode);
			front = newNode;
		}
	}
	public void addToBack(T newEntry)
	{
		SLNode<T> newNode = new SLNode<T>(newEntry);
		if (back == null)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			newNode.setPrev(back);
			back = newNode;
		}
	}
	
	/** Removes and returns the front/back entry of this dequeue.
		@return  The object at the front/back of the dequeue.
		@throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T removeFront()
	{
		if (front == null)
		{
			throw new EmptyQueueException();
		}
		else
		{
			T tempData = front.getData();
			front.setData(null);
			if (front == back)
			{
				front = null;
				back = null;
			}
			else
			{
				SLNode<T> lastNode = back;
				while (lastNode.getPrev() != front)
				{
					lastNode = lastNode.getPrev();
				}
				front = lastNode;
				front.setPrev(null);
			}
			return tempData;
		}
	}
	public T removeBack()
	{
		if (back == null)
		{
			throw new EmptyQueueException();
		}
		else
		{
			T tempData = back.getData();
			SLNode<T> newBack = back.getPrev();
			back.setPrev(null);
			back.setData(null);
			back = newBack;
			return tempData;
		}
	}
	
	/** Retrieves the front/back entry of this dequeue.
		@return  The object at the front/back of the dequeue.
		@throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T getFront()
	{
		if (front == null)
		{
			throw new EmptyQueueException();
		}
		else
		{
			return front.getData();
		}
	}
	public T getBack()
	{
		if (back == null)
		{
			throw new EmptyQueueException();
		}
		else
		{
			return back.getData();
		}
	}
		
	/**  Detects whether this dequeue is empty.
			@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return front == null && back == null;
	}
	
	public void clear()
	{
		if (!isEmpty())
		{
			SLNode<T> lastNode = back;
			while (lastNode.getPrev() != null)
			{
				lastNode.setData(null);
				SLNode<T> nextNode = lastNode.getPrev();
				lastNode.setPrev(null);
				lastNode = nextNode;
			}
			front.setData(null);
			front = null;
			back = null;
		}
	}
}