package structures;

import interfaces.InterfaceHashTable;

public class HashTable <K extends Comparable<K>, V> implements InterfaceHashTable<K, V>{

	private final int ARRAY_SIZE;
	private HashNode<K,V>[] array;
	
	private long size;
	
	@SuppressWarnings("unchecked")
	public HashTable(int arraySize) {
		ARRAY_SIZE = arraySize;
		size = 0;
		array = new HashNode[ARRAY_SIZE];
	}
	
	@Override
	public void add(K key, V value) {
		
		int index = hashFuntion(key);
		HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);

		if(array[index]!= null) {
			array[index].add(nodeAdd);
		}else {
			array[index] = nodeAdd;
		}
		
		size++;
	}

	@Override
	public V getValue(K key) {
		
		int index = hashFuntion(key);
		
		if(array[index] != null) {
			if(array[index].getKey().compareTo(key)==0) {
				return array[index].getValue();
			}else {
				return array[index].searchValue(key);
			}
		}else 
			return null;
	}

	@Override
	public boolean remove(K key) {
		int index = hashFuntion(key);
		if(array[index] != null) {
			if(array[index].getKey().compareTo(key)==0) {
				if(array[index].getNext()==null) {
					array[index] = null;
					
					size--;
					return true;
				}else {
					HashNode<K, V> aux = array[index];
					array[index] = aux.getNext();
					aux.getNext().setPrevious(null);
					
					size--;
					return true;
				}
			}else {
				if(array[index].removeValue(key)) {
					size--;
					return true;
				}else
					return false;
			}
		}else 
			return false;
	}

	@Override
	public boolean contains(K key) {
		V aux = getValue(key);
		if(aux==null)
			return false;
		else
			return true;
	}

	@Override
	public long getSize() {
		return size;
	}
	
	private int hashFuntion(K key) {
		int index = Math.abs(key.hashCode());

		if(index >= ARRAY_SIZE) {
			index = index % ARRAY_SIZE;
		}
		
		return index;
	}
}
