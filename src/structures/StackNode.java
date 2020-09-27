package structures;

public class StackNode <V>{
	
	private V value;
	
	private StackNode <V> next;
	
	public StackNode(V value, StackNode <V> next) {
		this.value = value;
		this.next = next;
	}
	
	public V getV() {
		return value;
	}
	
	public StackNode <V> getNext(){
		return next;
	}
	
	public void setNext(StackNode <V> next) {
		this.next = next;
	}

}