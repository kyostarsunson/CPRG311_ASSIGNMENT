package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyArrayList;

class MyArrayListTest
{
	private MyArrayList<String> myArrayList;

	@BeforeEach
	void setUp() throws Exception
	{
		// System.out.println("in setup");
		myArrayList = new MyArrayList();
	}

	@Test
	void testGet()
	{
		myArrayList.clear();
		// System.out.println("in testGet");
		myArrayList.add("1");
		assertEquals("1", myArrayList.get(1));
		myArrayList.add("2");
		assertEquals("2", myArrayList.get(2));
		myArrayList.add("3");
		assertEquals("3", myArrayList.get(3));

		assertEquals(null, myArrayList.get(5));
		// assertEquals(null, myArrayList.get(-1));
	}

	@Test
	void testAdd()
	{
		// System.out.println("in testAdd");
		myArrayList.clear();
		myArrayList.add("1");
		assertEquals(1, myArrayList.size());
		myArrayList.add("2");
		assertEquals(2, myArrayList.size());
		myArrayList.add("3");
		assertEquals(3, myArrayList.size());
	}

	@Test
	void testAddIndex()
	{
		myArrayList.clear();
		// System.out.println("in testClear");
		myArrayList.add(1, "1");
		assertEquals("[->1]", myArrayList.toString());
		myArrayList.add(2, "2");
		assertEquals("[->1->2]", myArrayList.toString());
		myArrayList.add(1, "3");
		assertEquals("[->3->1->2]", myArrayList.toString());
		// System.out.println("in testAddIndex" + myArrayList.toString());
	}

	@Test
	void testRemove()
	{
		// System.out.println("in testRemove");
		myArrayList.clear();

		myArrayList.add("1");
		myArrayList.remove(1);
		assertEquals(0, myArrayList.size());
		myArrayList.remove(2);
		assertEquals(0, myArrayList.size());

		// System.out.println("in testRemove, size=" + myArrayList.size());

	}

	@Test
	void testRemoveE()
	{
		// System.out.println("in testRemove");
		myArrayList.clear();
		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");
		myArrayList.remove("3");
		assertEquals("[->1->2]", myArrayList.toString());
		myArrayList.remove("2");
		assertEquals("[->1]", myArrayList.toString());
	}

	@Test
	void testSet()
	{
		// System.out.println("in testSet");
		myArrayList.clear();
		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");
		myArrayList.set(1, "5");

		assertEquals("[->5->2->3]", myArrayList.toString());
		// System.out.println(myArrayList.toString());
		myArrayList.set(3, "7");
		assertEquals("[->5->2->7]", myArrayList.toString());
	}

	@Test
	void testIsEmpty()
	{
		// System.out.println("in testIsEmpty");
		myArrayList.clear();

		assertEquals(true, myArrayList.isEmpty());
		myArrayList.add("1");
		assertEquals(false, myArrayList.isEmpty());
	}

	@Test
	void testContain()
	{
		// System.out.println("in testContain");
		myArrayList.clear();
		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");

		assertEquals(true, myArrayList.contains("1"));
		assertEquals(true, myArrayList.contains("3"));
		assertEquals(false, myArrayList.contains("4"));
	}

	@Test
	void testToArrayE()
	{
		System.out.println("in testToArrayE");
		myArrayList.clear();
		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");

		String[] myTestE = new String[myArrayList.size()];
		try
		{myTestE = myArrayList.toArray(myTestE);
		System.out.println(myArrayList.size());
			
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

		// assertEquals(true,);
//		assertEquals(false, myArrayList.contains("4"));

	}

	@Test
	void testToArray()
	{
		System.out.println("in testToArray");
		myArrayList.clear();
		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");

		assertEquals("1", myArrayList.toArray()[0]);
		assertEquals("2", myArrayList.toArray()[1]);
		assertEquals("3", myArrayList.toArray()[2]);
		assertEquals(null, myArrayList.toArray()[4]);
	}

	@Test
	void testSize()
	{
		// System.out.println("in testSize");
		myArrayList.clear();

		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");

		assertEquals(3, myArrayList.size());
		myArrayList.remove(3);
		assertEquals(2, myArrayList.size());

		// System.out.println("in testSize, size=" + myArrayList.size());
	}

	@Test
	void testClear()
	{
		myArrayList.clear();
		// System.out.println("in testClear");
		myArrayList.add("1");

		assertEquals(1, myArrayList.size());
		myArrayList.clear();
		// System.out.println("in testClear, size=" + myArrayList.size());
		assertEquals(0, myArrayList.size());
	}

}
