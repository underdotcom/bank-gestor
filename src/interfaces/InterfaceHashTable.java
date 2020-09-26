package interfaces;

public interface InterfaceHashTable <K, V>{
	
	public void add(K key, V value);
	public V getValue(K key);
	public boolean remove(K key);
	public boolean contains(K key);
	public long getSize();
	
}
