package structures;

import org.junit.Test;

public class HeapTest {

	private Heap<Integer, String> heap;
	
	void setUp1(){
		heap= new Heap<Integer, String>(6,6);
		heap.addHeapNode(Integer.valueOf(1), "valentina");
		heap.addHeapNode(Integer.valueOf(6), "Miguel");
		heap.addHeapNode(Integer.valueOf(3), "Jose Luis");
		heap.addHeapNode(Integer.valueOf(5), "Carlos");
		heap.addHeapNode(Integer.valueOf(4), "Luisa");
		heap.addHeapNode(Integer.valueOf(2), "Roberto");

	}
	
	void setUp2(){
		heap= new Heap<Integer, String>(10,6);
	}
	
	void setUp3(){
		
	}
	
	@Test
	public void heapify() {
		setUp1();
		
		HeapNode<Integer, String>[] array= heap.buildHeap();
		for (int i = 1; i < heap.getArraySize(); i++) {
			if(heap.right(i)!=-1) {
				System.out.println(array[i].getValue()+" hijos izq "+ array[heap.left(i)].getValue() + " der "+ array[heap.right(i)].getValue());
			}else {
				System.out.println(array[i].getValue()+" hijos izq "+ array[heap.left(i)].getValue());
			}
		}
	}
	
}
