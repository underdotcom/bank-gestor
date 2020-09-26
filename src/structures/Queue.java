package structures;

import interfaces.InterfaceQueue;

public class Queue <T> implements InterfaceQueue<T>{
	
	private QueueNode<T> front;
	private QueueNode<T> back;
	
	public Queue() {
		front = null;
		back = null;
	}
	
	public QueueNode<T> front(){
		return front;
	}
	
	@Override
	public void enqueue(T element) {
		QueueNode <T> newNode=new QueueNode<T>(element);
		QueueNode <T> aux= null;
		if(front==null) {
			front=new QueueNode<T>(element);
			back=front;
		}else if(back.equals(front)){
			aux=front;	
			aux.setNext(newNode);
			back=newNode;
		}else {
			back.setNext(newNode);
			back=newNode;
		}
	}
	
	@Override
	public boolean isEmpty() {
		boolean isEmpty=true;
		if(front!=null) 
			return isEmpty=false;
		else
			return isEmpty;
	}

	@Override
	public QueueNode<T> dequeue(){
		QueueNode<T> aux=null;
		if(front!=null) {
			aux=front;
			if(front.getNext()!=null) {
				if(front.getNext().equals(back)) {
					front=back;	
					front.setNext(null);
				}
				else 
					front=aux.getNext();
			}else {
					aux=front;
					back=front=null;
			}
		}
		return aux;
	}
}
