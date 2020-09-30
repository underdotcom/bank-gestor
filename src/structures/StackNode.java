package structures;

public class StackNode <V>{
	
	private V value;

	private StackNode <V> prev;
	
	public StackNode(V value) {
		this.value = value;
		prev=null;
	}
	
	public V getV() {
		return value;
	}
	
	public StackNode <V> getPrev(){
		return prev;
	}
	
	public void setPrev(StackNode <V> prev) {
		this.prev = prev;
	}

}