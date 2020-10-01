package sort_algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SortTest {
	
	private Integer[] arrayInt;
	private String[] arrayString;
	private ArrayList<Integer> listInt;
	private ArrayList<String> listString;
	private Sort<Integer> i;
	private Sort<String> s;
	
	void generateTestCases() {
		arrayInt = new Integer[5];
		arrayInt[0] = 5;
		arrayInt[1] = 2;
		arrayInt[2] = 4;
		arrayInt[3] = 3;
		arrayInt[4] = 1;
		
		listInt = new ArrayList<Integer>();
		listInt.add(5);
		listInt.add(2);
		listInt.add(4);
		listInt.add(3);
		listInt.add(1);
		
		arrayString = new String[4];
		arrayString[0] = "Alejandro";
		arrayString[1] = "jhon";
		arrayString[2] = "Jose";
		arrayString[3] = "Valentina";
		
		listString = new ArrayList<String>();
		listString.add("Alejandro");
		listString.add("jhon");
		listString.add("Jose");
		listString.add("Valentina");
	}
	
	void setup1(){
		i =  new BubbleSort<Integer>();
		s = new BubbleSort<String>();
		
		generateTestCases();
	}
	
	void setup2() {
		i = new MergeSort<Integer>();
		s = new MergeSort<String>();
		
		generateTestCases();
	}
	
	@Test
	void sortAscendingTest() {
		setup1();
		i.sortAscending(arrayInt);
		assertEquals(1, arrayInt[0]);
		assertEquals(2, arrayInt[1]);
		assertEquals(3, arrayInt[2]);
		assertEquals(4, arrayInt[3]);
		assertEquals(5, arrayInt[4]);
		
		i.sortAscending(listInt);
		assertEquals(1, listInt.get(0));
		assertEquals(2, listInt.get(1));
		assertEquals(3, listInt.get(2));
		assertEquals(4, listInt.get(3));
		assertEquals(5, listInt.get(4));
		
		s.sortAscending(arrayString);
		assertEquals("Alejandro", arrayString[0]);
		assertEquals("Jose", arrayString[1]);
		assertEquals("Valentina", arrayString[2]);
		assertEquals("jhon", arrayString[3]);
		
		s.sortAscending(listString);
		assertEquals("Alejandro", listString.get(0));
		assertEquals("Jose", listString.get(1));
		assertEquals("Valentina", listString.get(2));
		assertEquals("jhon", listString.get(3));
		
		setup2();
		i.sortAscending(arrayInt);
		assertEquals(1, arrayInt[0]);
		assertEquals(2, arrayInt[1]);
		assertEquals(3, arrayInt[2]);
		assertEquals(4, arrayInt[3]);
		assertEquals(5, arrayInt[4]);
		
		i.sortAscending(listInt);
		assertEquals(1, listInt.get(0));
		assertEquals(2, listInt.get(1));
		assertEquals(3, listInt.get(2));
		assertEquals(4, listInt.get(3));
		assertEquals(5, listInt.get(4));
		
		s.sortAscending(arrayString);
		assertEquals("Alejandro", arrayString[0]);
		assertEquals("Jose", arrayString[1]);
		assertEquals("Valentina", arrayString[2]);
		assertEquals("jhon", arrayString[3]);
		
		s.sortAscending(listString);
		assertEquals("Alejandro", listString.get(0));
		assertEquals("Jose", listString.get(1));
		assertEquals("Valentina", listString.get(2));
		assertEquals("jhon", listString.get(3));
	}
	
	@Test
	void sortDescendingTest() {
		setup1();
		i.sortDescending(arrayInt);
		assertEquals(5, arrayInt[0]);
		assertEquals(4, arrayInt[1]);
		assertEquals(3, arrayInt[2]);
		assertEquals(2, arrayInt[3]);
		assertEquals(1, arrayInt[4]);
		
		i.sortDescending(listInt);
		assertEquals(5, listInt.get(0));
		assertEquals(4, listInt.get(1));
		assertEquals(3, listInt.get(2));
		assertEquals(2, listInt.get(3));
		assertEquals(1, listInt.get(4));
		
		s.sortDescending(arrayString);
		assertEquals("jhon", arrayString[0]);
		assertEquals("Valentina", arrayString[1]);
		assertEquals("Jose", arrayString[2]);
		assertEquals("Alejandro", arrayString[3]);
		
		s.sortDescending(listString);
		assertEquals("jhon", listString.get(0));
		assertEquals("Valentina", listString.get(1));
		assertEquals("Jose", listString.get(2));
		assertEquals("Alejandro", listString.get(3));
		
		setup2();
		i.sortDescending(arrayInt);
		assertEquals(5, arrayInt[0]);
		assertEquals(4, arrayInt[1]);
		assertEquals(3, arrayInt[2]);
		assertEquals(2, arrayInt[3]);
		assertEquals(1, arrayInt[4]);
		
		i.sortDescending(listInt);
		assertEquals(5, listInt.get(0));
		assertEquals(4, listInt.get(1));
		assertEquals(3, listInt.get(2));
		assertEquals(2, listInt.get(3));
		assertEquals(1, listInt.get(4));
		
		s.sortDescending(arrayString);
		assertEquals("jhon", arrayString[0]);
		assertEquals("Valentina", arrayString[1]);
		assertEquals("Jose", arrayString[2]);
		assertEquals("Alejandro", arrayString[3]);
		
		s.sortDescending(listString);
		assertEquals("jhon", listString.get(0));
		assertEquals("Valentina", listString.get(1));
		assertEquals("Jose", listString.get(2));
		assertEquals("Alejandro", listString.get(3));
	}
}
