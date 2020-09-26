package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	private HashTable<String, String> sht;
	private HashTable<Integer, String> iht;
	
	void setup1(){
		sht = new HashTable<String, String>(5);
		iht = new HashTable<Integer, String>(5);
		
		iht.add(11, "Once");
		iht.add(21, "Veintiuno");
		iht.add(1193476214, "JHON SALDARRIAGA");
		
		sht.add("Saludo uno", "HOLA");
		sht.add("Saludo dos", "QUE ONDA");
		sht.add("Despido uno", "ADIOS");
		sht.add("Despido dos", "HASTA LUEGO");
	}
	
	@Test
	void getValueTest() {
		setup1();
		assertEquals(4, sht.getSize());
		assertEquals("HOLA", sht.getValue("Saludo uno"));
		assertEquals("QUE ONDA", sht.getValue("Saludo dos"));
		assertEquals("ADIOS", sht.getValue("Despido uno"));
		assertEquals("HASTA LUEGO", sht.getValue("Despido dos"));
		
		assertEquals(3, iht.getSize());
		assertEquals("Once", iht.getValue(11));
		assertEquals("Veintiuno", iht.getValue(21));
		assertEquals("JHON SALDARRIAGA", iht.getValue(1193476214));
	}
	
	@Test
	void contaisTest() {
		setup1();
		assertTrue(sht.contains("Saludo uno"));
		assertTrue(sht.contains("Saludo dos"));
		assertTrue(sht.contains("Despido uno"));
		assertTrue(!sht.contains("Despido tres"));
		assertTrue(sht.contains("Despido dos"));
		
		assertTrue(iht.contains(11));
		assertTrue(iht.contains(21));
		assertTrue(!iht.contains(0));
		assertTrue(iht.contains(1193476214));
	}
	
	@Test
	void removeTest() {
		setup1();
		assertEquals(4, sht.getSize());
		assertEquals(true, sht.remove("Saludo uno"));
		assertEquals(3, sht.getSize());
		assertEquals(true, sht.remove("Saludo dos"));
		assertEquals(2, sht.getSize());
		assertEquals(true, sht.remove("Despido uno"));
		assertEquals(1, sht.getSize());
		assertEquals(false, sht.remove("Despido tres"));
		assertEquals(1, sht.getSize());
		assertEquals(true, sht.remove("Despido dos"));
		assertEquals(0, sht.getSize());
		
		assertEquals(null, sht.getValue("Saludo uno"));
		assertEquals(null, sht.getValue("Saludo dos"));
		assertEquals(null, sht.getValue("Despido uno"));
		assertEquals(null, sht.getValue("Despido dos"));
		
		assertEquals(3, iht.getSize());
		assertEquals(true, iht.remove(11));
		assertEquals(null, iht.getValue(11));
		assertEquals(2, iht.getSize());
		assertEquals(true, iht.remove(21));
		assertEquals(null, iht.getValue(21));
		assertEquals(1, iht.getSize());
		assertEquals(false, iht.remove(0));
		assertEquals(1, iht.getSize());
		assertEquals(true, iht.remove(1193476214));
		assertEquals(null, iht.getValue(1193476214));
		assertEquals(0, iht.getSize());
	}

}
