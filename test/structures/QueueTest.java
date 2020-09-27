package structures;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class QueueTest {
	private Queue <String> stringQueue;
	
	void setUp1() {
		stringQueue = new Queue<String>();
	}
	
	@Test
	void enqueueTest() {
		setUp1();
		////Normal case. Just one person in the Queue and after more people
		stringQueue.enqueue("Valentina");
		assertEquals("Valentina", stringQueue.front().getData());
		
		setUp1();
		stringQueue.enqueue("Alejandro");
		stringQueue.enqueue("Jose");
		assertEquals("Alejandro", stringQueue.front().getData());
		
		///Medium case. People added and also, people deleted
		setUp1();
		stringQueue.enqueue("Antonio");
		stringQueue.dequeue();
		stringQueue.enqueue("Felipe");
		stringQueue.enqueue("Jose");
		stringQueue.enqueue("Luisa");
		stringQueue.dequeue();
		stringQueue.enqueue("David");
		stringQueue.dequeue();
		assertEquals("Luisa", stringQueue.front().getData());
		
		///Rare case.
		setUp1();
		stringQueue.enqueue("Antonio");
		stringQueue.dequeue();
		stringQueue.enqueue("Felipe");
		stringQueue.enqueue("Jose");
		stringQueue.enqueue("Cristian");
		stringQueue.dequeue();
		stringQueue.enqueue("Maricela");
		stringQueue.enqueue("Alfonso");
		stringQueue.dequeue();
		stringQueue.enqueue("Luisa");
		stringQueue.dequeue();
		assertEquals("Maricela", stringQueue.front().getData());	
	}
	
	@Test
	void dequeueTest() {
		setUp1();
		/// Normal case. Just one person added and deleted.
		stringQueue.enqueue("Brigitte");
		assertEquals("Brigitte", stringQueue.front().getData());
		assertEquals("Brigitte", stringQueue.dequeue().getData());
		
		///Medium case. Several persons added and deleted
		stringQueue.enqueue("Fernando");
		stringQueue.enqueue("Luis");
		stringQueue.dequeue();
		assertEquals("Luis", stringQueue.dequeue().getData());
		
		stringQueue.enqueue("Valentina");
		stringQueue.enqueue("Gertrudes");
		stringQueue.enqueue("Sofia");
		assertEquals("Valentina" , stringQueue.front().getData());
		stringQueue.enqueue("Lina");
		stringQueue.dequeue();
		assertEquals("Gertrudes" , stringQueue.dequeue().getData());
		
		//rare case. An extreme erased of nodes.
		stringQueue.dequeue();
		assertEquals("Lina", stringQueue.dequeue().getData());
		try {
			stringQueue.dequeue();
		}catch(NullPointerException e) {
			stringQueue.enqueue("Working");
			assertEquals("Working", stringQueue.dequeue());
		}
	}
	
	@Test
	void isEmpty() {
		/// Normal case. Queue empty
		setUp1();
		assertEquals(true, stringQueue.isEmpty());
	
		/// Medium case. Queue with just one Node and after, several ones
		stringQueue.enqueue("Damian");
		assertEquals(false, stringQueue.isEmpty());
		stringQueue.dequeue();
		
		stringQueue.enqueue("Fercho");
		stringQueue.enqueue("Luisa");
		stringQueue.dequeue();
		stringQueue.enqueue("George");
		stringQueue.enqueue("Sofia");
		stringQueue.enqueue("Augusto");
		stringQueue.dequeue();
		assertEquals(false, stringQueue.isEmpty());
		
		stringQueue.dequeue();
		stringQueue.dequeue();
		stringQueue.dequeue();
		assertEquals(true, stringQueue.isEmpty());
	}
	
	@Test
	void front() {
		setUp1();
		///Normal case.
		try {
			stringQueue.front();
		}catch(NullPointerException e) {
			stringQueue.enqueue("Working");
			assertEquals("Working",stringQueue.front().getData());
		}
		
		//Medium case
		setUp1();
		stringQueue.enqueue("Fercho");
		stringQueue.enqueue("Luisa");
		assertEquals("Fercho", stringQueue.front().getData());
		
		//Rare case.
		setUp1();
		stringQueue.enqueue("Damian");
		assertEquals("Damian", stringQueue.front().getData());
		stringQueue.dequeue();
		
		stringQueue.enqueue("Fercho");
		stringQueue.enqueue("Luisa");
		stringQueue.dequeue();
		stringQueue.enqueue("George");
		stringQueue.enqueue("Sofia");
		stringQueue.dequeue();
		stringQueue.enqueue("Augusto");
		stringQueue.dequeue();
		assertEquals("Sofia", stringQueue.front().getData());
	}
}
