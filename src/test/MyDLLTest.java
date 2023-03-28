package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyDLL;

class MyDLLTest
{
	private MyDLL<String> myDLL;

	@BeforeEach
	void setUp() throws Exception
	{
		// System.out.println("in setup");
		myDLL = new MyDLL();
	}

	@Test
	void testHasNext()
	{
		myDLL.clear();
		assertFalse(myDLL.hasNext());
		myDLL.add("1");
		assertTrue(myDLL.hasNext());
	}

	@Test
	void testNext()
	{
		myDLL.clear();
		// System.out.println("next:" + myDLL.next());
		assertEquals(null, myDLL.next());
		myDLL.add("1");
		assertEquals("1", myDLL.next());
		myDLL.add("2");
		assertEquals("2", myDLL.next());
	}

	@Test
	void testSize()
	{
		myDLL.clear();
		assertEquals(0, myDLL.size());
		myDLL.add("1");
		assertEquals(1, myDLL.size());
	}

	@Test
	void testClear()
	{
		myDLL.clear();
		assertEquals(0, myDLL.size());
		myDLL.add("1");
		myDLL.clear();
		assertEquals(0, myDLL.size());
	}

	@Test
	void testAddIntE()
	{
		myDLL.clear();
		myDLL.add(1, "1");
		// System.out.println(myDLL.get(1));
		assertEquals("1", myDLL.get(1));
		myDLL.add(2, "2");
		myDLL.add(3, "3");
		assertEquals("3", myDLL.get(3));
		myDLL.add(1, "0");
		assertEquals("3", myDLL.get(4));
		assertEquals(null, myDLL.get(5));
	}

	@Test
	void testAddE()
	{
		myDLL.clear();
		myDLL.add("1");
		// System.out.println(myDLL.get(1));
		assertEquals("1", myDLL.get(1));
		myDLL.add("2");
		myDLL.add("3");
		assertEquals("3", myDLL.get(3));
		assertEquals(null, myDLL.get(4));
	}

	@Test
	void testAddAll()
	{

	}

	@Test
	void testGet()
	{
		myDLL.clear();
		myDLL.add("1");
		// System.out.println(myDLL.get(1));
		assertEquals("1", myDLL.get(1));
		assertEquals(null, myDLL.get(2));
	}

	@Test
	void testRemoveInt()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");

		myDLL.remove(1);
		assertEquals("[2]", myDLL.toString());
		myDLL.remove(1);
		assertEquals("[]", myDLL.toString());
	}

	@Test
	void testRemoveE()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");
		myDLL.add("3");
		myDLL.add("4");

		myDLL.remove("1");
		assertEquals("[234]", myDLL.toString());
		myDLL.remove("4");
		assertEquals("[23]", myDLL.toString());
		myDLL.remove("4");
		assertEquals("[23]", myDLL.toString());
	}

	@Test
	void testSet()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");
		myDLL.add("3");

		myDLL.set(1, "6");
		assertEquals("[623]", myDLL.toString());
		myDLL.set(3, "1");
		assertEquals("[621]", myDLL.toString());
		myDLL.set(4, "0");
		assertEquals("[621]", myDLL.toString());
	}

	@Test
	void testIsEmpty()
	{
		myDLL.clear();
		assertTrue(myDLL.isEmpty());
		myDLL.add("1");
		assertFalse(myDLL.isEmpty());
	}

	@Test
	void testContains()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");
		myDLL.add("3");
		myDLL.add("4");

		assertTrue(myDLL.contains("1"));
		assertTrue(myDLL.contains("4"));
		assertFalse(myDLL.contains("5"));
	}

	@Test
	void testToArrayEArray()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");
		myDLL.add("3");

		String[] toHold = new String[myDLL.size()];
		myDLL.toArray(toHold);

		assertEquals("1", toHold[0]);
		assertEquals("2", toHold[1]);
		assertEquals("3", toHold[2]);

	}

	@Test
	void testToArray()
	{
		myDLL.clear();
		myDLL.add("1");
		myDLL.add("2");
		myDLL.add("3");

		String[] toHold = new String[myDLL.size()];
		toHold = myDLL.toArray(toHold);

		assertEquals("1", myDLL.toArray()[0]);
		assertEquals("2", myDLL.toArray()[1]);
		assertEquals("3", myDLL.toArray()[2]);
	}

}
