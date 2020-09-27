package structures;

import interfaces.InterfaceStack;

public class Stack <V> implements InterfaceStack <V> {
	
	private StackNode <V> head;
	
	private int size;
	
	public Stack() {
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void push(V value) {
		head= new StackNode <V> (value,head);
	}
	
	@Override
	public V top() {
		V value = null;
		
		if(head != null) {
			value = head.getV();
			head = head.getNext();
		}return value;
	}
	
	@Override
	public V pop() {
		V value = null;
		
		if(head != null) {
			value = head.getV();
			head = head.getNext();
		}return null;
	}

}