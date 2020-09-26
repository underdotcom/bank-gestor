package interfaces;

import structures.QueueNode;

public interface InterfaceQueue <T> {

	public QueueNode<T> dequeue();
	public boolean isEmpty() ;
	public void enqueue(T element); 
	public QueueNode<T> front();
	
}
