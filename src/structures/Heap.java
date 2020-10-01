package structures;

import interfaces.InterfaceHeap;

public class Heap <K extends Comparable<K>, V> implements InterfaceHeap {
	
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
					System.out.println(array[l].getKey()+" L win against to "+ array[index].getKey());
					largest=l;	
					System.out.println(index + "es  "+ l);
				}
			}
			if(r!=-1) {
				System.out.println(array[largest].getKey() + "largest vs r" + array[r].getKey());
				if( r<=heapSize && array[r].getKey().compareTo(array[largest].getKey())>0) {
					System.out.println(array[r].getKey()+" win against "+ array[index].getKey());
					largest=r;
				}
			}
			System.out.println(largest+" comparacion final " + index);
			if(largest>index ||	 largest<index) {
				HeapNode<K,V> aux=array[largest];
				System.out.println("largest pasa a ser "+largest+ "index"+index);
				array[largest]=array[index];
				System.out.println("index para a ser "+aux.getValue() );
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

	public boolean addHeapNode(K key, V value) {
		if(available<array_size) {
			array[available]=new HeapNode<K,V>(key, value);
			available++;
			return true;
		}else {
			return false;
		}
	}	
}
