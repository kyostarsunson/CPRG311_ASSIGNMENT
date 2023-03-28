package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyStack;

class MyStackTests
{

	private MyStack<String> myStack;

	@BeforeEach
	void setUp() throws Exception
	{
		// System.out.println("in setup");
		myStack = new MyStack();
	}

	@Test
	void testPeek()
	{
		myStack.clear();
		// System.out.println("in testGet");
		myStack.push("1");
		assertEquals("1", myStack.peek());
		myStack.push("2");
		assertEquals("2", myStack.peek());
	}

	@Test
	void testPush()
	{
		myStack.clear();
		// System.out.println("in testGet");
		myStack.push("1");
		assertEquals("1", myStack.peek());
		myStack.push("2");
		assertEquals("2", myStack.peek());
	}

	@Test
	void testPop()
	{
		myStack.clear();
		// System.out.println("in testGet");
		myStack.push("1");
		myStack.push("2");
		assertEquals("2", myStack.pop().toString());
		myStack.pop();
		assertEquals(null, myStack.peek());
	}

	@Test
	void testClear()
	{
		myStack.clear();
		assertEquals(0, myStack.size());
	}

	@Test
	void testIsEmpty()
	{
		myStack.clear();
		assertTrue(myStack.isEmpty());
		myStack.push("1");
		assertTrue(!myStack.isEmpty());
	}

	@Test
	void testToArray()
	{
		myStack.clear();
		myStack.push("1");
		myStack.push("2");
		myStack.push("3");

		assertEquals("1", myStack.toArray()[2]);
		assertEquals("2", myStack.toArray()[1]);
		assertEquals("3", myStack.toArray()[0]);
	}

	@Test
	void testContains()
	{
		myStack.clear();
		myStack.push("1");
		myStack.push("2");
		myStack.push("3");

		assertEquals(true, myStack.contains("1"));
		assertEquals(true, myStack.contains("3"));
		assertEquals(false, myStack.contains("4"));
	}

	@Test
	void testSearch()
	{
		myStack.clear();
		myStack.push("1");
		myStack.push("2");
		myStack.push("3");

		assertEquals(3, myStack.search("1"));
		assertEquals(1, myStack.search("3"));
		assertEquals(0, myStack.search("4"));
	}

	@Test
	void testEqual()
	{
		myStack.clear();
		myStack.push("1");
		myStack.push("2");
		myStack.push("3");

		MyStack<String> targetStack = new MyStack<>();
		targetStack.push("1");
		targetStack.push("2");
		targetStack.push("3");

		assertTrue(myStack.equals(targetStack));
		targetStack.push("4");
		targetStack.pop();
		targetStack.pop();
		assertFalse(myStack.equals(targetStack));
		targetStack.push("3");
		assertTrue(myStack.equals(targetStack));
	}

	@Test
	void testSize()
	{
		myStack.clear();
		myStack.push("1");
		myStack.push("2");
		myStack.push("3");
		assertEquals(3, myStack.size());
	}
}
