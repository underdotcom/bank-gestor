package interfaces;

import structures.HeapNode;

public interface InterfaceHeap <K extends Comparable<K>, V> {
	
	int father(int index);
	int left(int index);
	int right(int index);
	HeapNode<K, V>[] heapify(int index);
	HeapNode<K,V>[] buildHeap();
	int getArraySize();
	boolean addHeapNode(K key, V value, int priority);
	boolean insert(HeapNode<K,V> C);
	HeapNode<K,V> extracMax();

}
