/**
	A class implementing an ADT QUEUE using a double linked node.
	@author Drue Hidalgo
*/

public class DLDeque<T> implements DequeInterface<T>
{
	private DLNode<T> front;
	private DlNode<T> back;
	
	public DLDeque()
	{
		front = null;
		back = null;
	}
	
	public DLDeque(DLNode<T> firstNode)
    {
		head = firstNode;
		tail = firstNode;
    }
   
	/** Adds a new entry to the front/back of this dequeue.
       @param newEntry  An object to be added. */
	public void addToFront(T newEntry)
	{
		DLNode newNode = new DLNode<T>(newEntry);
		if (front == null)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			front.setPrev(newNode);
			newNode.setNext(front);
			front = newNode;
		}
	}
	
    public void addToBack(T newEntry)
	{
		DLNode<T> newNode = new DLNode<T>(newEntry);
		if (back == null)
		{
			front = newNode;
			back = newNode;
		}
		else
		{
			back.setNext(newNode);
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
			if (front.getNext() == null)
			{
				front = null;
				back = null;
			}
			else
			{
				front = front.getNext();
				front.setPrev(null);
			}
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
			back.setData(null);
			if(tail.getPrev() == null)
			{
				front = null;
				back = null;
			}
			else
			{
				back = back.getPrev();
				back.setNext(null);
			}
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
	
	public boolean isEmpty()
	{
		return front == null && back == null;
	}
	
	public void clear()
	{
		if(!isEmpty())
		{
			DLNode<T> lastNode = back;
			while(lastNode.getPrev() != null)
			{
				lastNode.setData(null);
				DLNode<T> nextNode = lastNode.getPrev();
				lastNode.setPrev(null);
				lastNode.setNext(null);
				lastNode = nextNode;
			}
			front.setData(null);
			back.setData(null);
			front = null;
			back = null;
		}
	}
}