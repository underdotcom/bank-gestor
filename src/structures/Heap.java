package structures;

public class Heap <T, V> {
	
	private HeapNode<T,V>[] array;
	private int heapSize;
	private int array_size;
	private int available;
	
	@SuppressWarnings("unchecked")
	public Heap (int arraySize, int heapSize) {
		array_size = arraySize;
		this.heapSize=heapSize;
		array = new HeapNode[array_size];
	}
	
	public int father(int index){
		return (int)Math.floor((double)index/2);
	}
	
	public int left(int index){
		return (int)(Math.floor((double)(2*index)));
	}
	
	public int right(int index){
		return (int)(Math.floor((double)(2*index+1)));
	}
	
	public boolean addHeapNode(T key, V value) {
		if(available>array_size) {
			array[available]=new HeapNode<T,V>(key, value);
			available++;
			return true;
		}else {
			return false;
		}
		
	}
	 
	public HeapNode<T, V>[] heapify(int index) {
	
		int l = left(index);
		int r = right(index);
		int largest=index;
		if( l<= heapSize && array[l].compareTo(array[index].getKey())>0){
			largest=l;
		}else {
			largest=index;
		}
		
		if( r<=heapSize && array[r].compareTo(array[largest].getKey())>0) {
			largest=r;
		}else {
			
		}
		if(largest!=index) {
			array[index]=array[largest];
			heapify(largest);
		}else {
			return array;
		}
		
		return array;
	}
	
	public void buildHeap() {
		heapSize=array.length;
		for (int i = (int)(Math.floorDiv(array.length, 2)) ; i>=0; i--) {
			array=heapify(i);
		}
		
	}
	
	public int getArraySize() {
		return array_size;
	}
	
	public HeapNode<T,V>[] getArray(){
		return array;
	}
	
}
