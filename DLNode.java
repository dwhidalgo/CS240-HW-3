/**
	A double linked node that stores pointers for the front and the back of the node and stores data.
	@author Drue Hidalgo
 */
 public class DLNode<T>
 {
	private DLNode<T> front;
	private DLNode<T> back;
	private T data;
	 
	public DLNode
	{
		front = null;
		back = null;
		data = null;
	}
	
	public DLNode(T newData)
	{
		front = null;
		back = null;
		data = newData;
	}
	
	public void setPrev(DLNode<T> frontNode)
	{
		front = frontNode;
	}
	
	public void setNext(DLNode<T> backNode)
	{
		back = backNode;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public DLNode<T> getPrev()
	{
		return front;
	}
	
	public DLNode<T> getNext()
	{
		return back;
	}
	
	public T getData()
	{
		return data;
	}
 }