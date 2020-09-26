package model;

public interface InterfaceQueue <T> {

	public Node<T> dequeue();
	public boolean isEmpty() ;
	public void enqueue(T element); 
	public Node<T> front();
	
}
