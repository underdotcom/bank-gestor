package structures;

public class HeapNode <T,V> implements Comparable <T> {

	public T key;
	public V value;
	
	public HeapNode(T key, V value) {
		this.key=key;
		this.value=value;
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

	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
