package structures;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class StackTest  {
	
	private Stack <String> stack;

	public void setUp1() {
		stack= new Stack<String>();
	}
	
	@Test
	public void isEmpty() {
		setUp1();
		
		///// First Case////
		assertTrue(stack.isEmpty(), "Stack does not has element");
		
		//// Second Case///
		stack.push("Hola");
		assertFalse(stack.isEmpty(), "Stack has elements, but it doesnt detected");
		
		//// Third Case///
		stack.push("buenos");
		stack.push("dias");
		assertFalse(stack.isEmpty(), "Stack has elements, but it doesnt detected");
		
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty(), "Stack does not has element");
	}
	
	@Test
	public void pushTest() {
		setUp1();
		/////////// First Case. The stack is empty and a new element is pushed
		stack.push("Hi");
		assertEquals(stack.top().getV(), "Hi");
		
		/////////// Second Case. The stack have more elements
		stack.push("Alicia");
		stack.push("I want to confess you");
		stack.push("that");
		stack.push("i really love you");
		assertEquals(stack.top().getV(), "i really love you");
		
		/////////// Third Case. The stack have elements, a half is erased and then is pushed another one
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(stack.top().getV(), "Alicia");
		stack.push("I hope you be ok");
		stack.push(",see you in the office");
		assertEquals(stack.top().getV(), ",see you in the office");
		
	}
	
	@Test
	public void top() {
		setUp1();
		//// First Case. The stack is empty
		assertEquals(stack.top(), null);
		
		/// Second Case. The stack have one element
		stack.push("Hi");
		assertEquals(stack.top().getV(), "Hi");
		
		/// Third Case. The stack have one element and it is erased
		stack.pop();
		assertEquals(stack.top(), null);
		
	}
	
	@Test
	public void pop() {
		setUp1();
		
	/// First case. The stack just have one element
		stack.push("Hello");
		assertEquals(stack.pop().getV(), "Hello");
		
		
	//// Second Case. The stack have elements, few are erased
			stack.push("Hi");
			stack.push("I'm alfred");
			stack.push("how are you?");
			stack.push("I hope you be fine.");
			stack.push(" It's been a while since the last time, isn't?");
			
			assertEquals(stack.top().getV(), " It's been a while since the last time, isn't?");
			
			
			stack.push("I really miss you.");
			stack.push("Can we met someday?");
			
			assertEquals(stack.top().getV(), "Can we met someday?");
			
			assertEquals(stack.pop().getV(), "Can we met someday?");
			assertEquals(stack.pop().getV(), "I really miss you.");
			
			assertEquals(stack.top().getV(), " It's been a while since the last time, isn't?");
			assertEquals(stack.pop().getV(), " It's been a while since the last time, isn't?");
			stack.pop();
			
			assertEquals(stack.top().getV(), "how are you?");
			
			assertEquals(stack.pop().getV(),"how are you?");
			stack.pop();
			stack.pop();
			
			assertNull(stack.top(), "The stack is empty");
	
	}
}
