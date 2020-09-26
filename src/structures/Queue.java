package model;

public class Queue <T> implements InterfaceQueue<T>{
	
	private Node<T> front;
	private Node<T> back;
	
	public Node<T> front(){
		return front;
	}
	
	@Override
	public void enqueue(T element) {
		Node <T> newNode=new Node<T>(element);
		Node <T> aux= null;
		if(front==null) {
			front=new Node<T>(element);
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
	public Node<T> dequeue(){
		Node<T> aux=null;
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
