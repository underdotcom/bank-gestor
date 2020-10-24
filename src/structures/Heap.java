package structures;

import interfaces.InterfaceHeap;

public class Heap <K extends Comparable<K>, V> implements InterfaceHeap <K,V>{
	
	private HeapNode< K,V>[] array;
	private int heapSize;
	private int array_size;
	private int available;
	
	@SuppressWarnings("unchecked")
	public Heap (int arraySize, int heapSize) {
		array_size = arraySize+1;
		this.heapSize=heapSize;
		available=1;
		array = new HeapNode[array_size];
	}
	
	@Override
	public int father(int index){
		return (int)Math.floor((double)index/2);
	}
	
	@Override
	public int left(int index){
		if(index==0) {
			return -1;
		}else {
		return (int)(Math.floor((double)(2*index)));
		}
	}
	
	@Override
	public int right(int index){
		if(index==0) {
			return -1;
		}else {
			if(2*index+1>=array_size) {
				return -1;
			}else {
				return (int)(Math.floor((double)((2*index)+1)));
			}	
		}
		
	}

	 
	@Override
	public HeapNode<K, V>[] heapify(int index) {
	
			int l = left(index);
			int r = right(index);
			int largest=index;

			if(l!=-1 ) {
				System.out.println(array[largest].getKey());
				if( l<= heapSize && array[l].getKey().compareTo(array[index].getKey())>0){
					largest=l;	
				}
			}
			if(r!=-1) {
				
				if( r<=heapSize && array[r].getKey().compareTo(array[largest].getKey())>0) {
				
					largest=r;
				}
			}

			if(largest>index ||	 largest<index) {
				HeapNode<K,V> aux=array[largest];
				array[largest]=array[index];
				array[index]=aux;
			}else {
				return array;
			}
			
			heapify(largest);
		return array;
	}
	
	@Override
	public HeapNode<K,V>[] buildHeap() {
		int div= (int)(Math.floor(array.length/2));
		for (int i = div; i>0; i--) {
			array=heapify(i);
		}

		return array;
	}
	
	@Override
	public int getArraySize() {
		return array_size;
	}

	public boolean addHeapNode(K key, V value, int priority) {
		if(available<array_size) {
			array[available]=new HeapNode<K,V>(key, value, priority);
			available++;
			return true;
		}else {
			return false;
		}
	}	
	////Insert a new Element
	public boolean insert(HeapNode<K,V> C) {
		
		heapSize= heapSize+1;
		int index=heapSize;
		
		try {
		while(index>1 && array[father(index)].getKey().compareTo(C.getKey())>0) {
			HeapNode<K,V> aux=array[index];
			array[index]=array[father(index)];
			array[father(index)]=aux;
			index=father(index);
		}
		}catch(NullPointerException e) {
			
		}
		array[index]=C;
		return false;
	}
	
	///// Extract the max object
	public HeapNode<K,V> extracMax() {
		HeapNode<K,V> max=null;
		if(array_size<0) {
			return null;
		}else {
			max=array[1];
			array[1]=array[heapSize];
			heapSize= heapSize-1;
			heapify(1);
		}
		return max;
	}
	
}
