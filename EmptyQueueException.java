/**
	Thrown by queue methods to indicate the queue is empty. 
	@author Drue Hidalgo
 */
public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        super("Queue is Empty");
    }
}