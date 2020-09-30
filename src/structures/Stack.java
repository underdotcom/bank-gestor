package structures;
import interfaces.InterfaceStack;

public class Stack <V> implements InterfaceStack <V> {
	
	private StackNode <V> top;	
	private int size;
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void push(V value) {
			if(top!=null) {
				StackNode<V> aux= top;
				top=new StackNode<V>(value);
				top.setPrev(aux);
			}else {
				top= new StackNode<V>(value);
			}
			size++;
	}
	
	@Override
	public StackNode<V> top() {

		if(top != null) {
			return top;
		}
		return null;
	}
	
	@Override
	public StackNode<V> pop() {
		StackNode<V> aux= null;
		if(top != null) {
			aux=top;
			if(top.getPrev()!=null) {
				top = top.getPrev();
			}else {
				top = null;
			}
		}
		size--;
		return aux;
	}

}