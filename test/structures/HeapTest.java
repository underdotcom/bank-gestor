package structures;

import org.junit.Test;

public class HeapTest {

	private Heap<Integer, String> heap;
	
	void setUp1(){
		heap= new Heap<Integer, String>(7,6);
		heap.addHeapNode(Integer.valueOf(1), "valentina");
		heap.addHeapNode(Integer.valueOf(1), "Miguel");
		heap.addHeapNode(Integer.valueOf(3), "Jose Luis");
		heap.addHeapNode(Integer.valueOf(5), "Carlos");
		heap.addHeapNode(Integer.valueOf(4), "Luisa");
	}
	
	void setUp2(){
		heap= new Heap<Integer, String>(10,6);
	}
	
	void setUp3(){
		
	}
	
	@Test
	public void heapify() {
		setUp1();
		//heap.buildHeap();
		HeapNode<Integer, String>[] array= heap.getArray();
		for (int i = 0; i < heap.getArraySize(); i++) {
			System.out.println(array[i]);
		}
	}
	
}
