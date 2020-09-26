package structures;

public class HashNode<K extends Comparable<K>, V>{

	private K key; 
	private V value; 
	
	private HashNode<K,V> next;
	private HashNode<K,V> previous; 
	
	public HashNode(K key, V value) {
		
		this.key = key;
		this.value = value;
		next = null; 
		previous = null;  
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashNode<K, V> getNext() {
		return next;
	}

	public void setNext(HashNode<K, V> next) {
		this.next = next;
	}
	
	public HashNode<K, V> getPrevious() {
		return previous;
	}

	public void setPrevious(HashNode<K, V> previus) {
		this.previous = previus;
	}

	public void add(HashNode<K, V> node) {
		if(next == null) {
			next = node;
		}else {
			next.add(node);
		}
	}

	public boolean removeValue(K key) {
		if(next != null) {
			if(next.getKey().compareTo(key)==0) {
				HashNode<K,V> aux = next;
				if(next.getNext()!=null) {
					aux.getPrevious().setNext(aux.getNext());
					aux.getNext().setPrevious(aux.getPrevious());
				}else {
					aux.getPrevious().setNext(null);
				}
				return true;
			}else {
				return next.removeValue(key);
			}
		}else 
			return false;
	}

	public V searchValue(K key) {
		if(next != null) {
			if(next.getKey().compareTo(key)==0) {
				return next.getValue();
			}else {
				return next.searchValue(key);
			}
		}else 
			return null;
	}
}

