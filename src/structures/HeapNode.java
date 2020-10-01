package structures;

public class HeapNode<T ,V> {

	public T key;
	public V value;
	public int priority;
	
	public HeapNode(T key, V value, int p) {
		this.key=key;
		this.value=value;
		this.priority=p;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public void setPriority(int p) {
		priority= p;
	}

	public int getPriority() {
		return priority;
	}
}
