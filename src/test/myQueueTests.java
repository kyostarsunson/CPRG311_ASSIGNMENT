package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyQueue;

class myQueueTests
{
	private MyQueue<String> myQueue;

	@BeforeEach
	void setUp() throws Exception
	{
		// System.out.println("in setup");
		myQueue = new MyQueue();
	}

	@Test
	void testHasNext()
	{
		myQueue.dequeueAll();
		assertFalse(myQueue.hasNext());
		myQueue.enqueue("1");
		assertTrue(myQueue.hasNext());
	}

	@Test
	void testNext()
	{
		myQueue.dequeueAll();
		assertEquals(null, myQueue.next());
		myQueue.enqueue("1");
		assertEquals("1", myQueue.next());
	}

	@Test
	void testEnqueue()
	{
		try
		{
			myQueue.dequeueAll();
			myQueue.enqueue("1");
			assertEquals("1", myQueue.peek());
			myQueue.enqueue("2");
			// System.out.println(myQueue.peek());
			assertEquals("1", myQueue.peek());
			myQueue.dequeue();
			assertEquals("2", myQueue.peek());
		} catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}

	}

	@Test
	void testDequeue()
	{
		try
		{
			myQueue.dequeueAll();
			myQueue.enqueue("1");
			myQueue.enqueue("2");
			assertEquals("1", myQueue.dequeue());
			assertEquals("2", myQueue.peek());

		} catch (Exception e)
		{
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testPeek()
	{
		try
		{
			int c = 1;
			myQueue.dequeueAll();
			myQueue.enqueue("1");
			myQueue.enqueue("2");
			// System.out.println(myQueue.peek());
			assertEquals("1", myQueue.peek());
			myQueue.dequeue();
			// System.out.println(myQueue.peek());
			assertEquals("2", myQueue.peek());
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}

	}

	@Test
	void testDequeueAll()
	{
		myQueue.dequeueAll();
		myQueue.enqueue("1");
		myQueue.dequeueAll();
		assertEquals(0, myQueue.size());
		myQueue.dequeueAll();
		assertEquals(0, myQueue.size());
	}

	@Test
	void testIsEmpty()
	{
		myQueue.dequeueAll();
		assertEquals(true, myQueue.isEmpty());
		myQueue.enqueue("1");
		assertEquals(false, myQueue.isEmpty());
	}

	@Test
	void testEqualsQueueADTOfE()
	{
		try
		{
			myQueue.dequeueAll();
			myQueue.enqueue("1");
			myQueue.enqueue("2");
			myQueue.enqueue("3");

			MyQueue<String> targetQueue = new MyQueue<>();
			targetQueue.enqueue("1");
			targetQueue.enqueue("2");
			targetQueue.enqueue("3");

			assertTrue(myQueue.equals(targetQueue));
			targetQueue.dequeue();
			assertFalse(myQueue.equals(targetQueue));
			myQueue.dequeue();
			assertTrue(myQueue.equals(targetQueue));
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}

	}

	@Test
	void testToArray()
	{
		myQueue.dequeueAll();
		myQueue.enqueue("1");
		myQueue.enqueue("2");
		myQueue.enqueue("3");

		assertEquals("2", myQueue.toArray()[1]);
		assertEquals("3", myQueue.toArray()[2]);
	}

	@Test
	void testToArrayEArray()
	{
//		myQueue.dequeueAll();
//		myQueue.enqueue("1");
//		myQueue.enqueue("2");
//		myQueue.enqueue("3");
//
//		String[] tmp = new String[myQueue.size()];
//		try
//		{
//			tmp = myQueue.toArray(tmp);
//		} catch (Exception e)
//		{
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//
//		System.out.println(tmp[1]);
//
//		assertEquals("2", tmp[1]);
//		assertEquals("3", myQueue.toArray(null));
	}

	@Test
	void testIsFull()
	{
		assertFalse(this.myQueue.isFull());
		for (int i = 0; i < 100; i++)
		{
			this.myQueue.enqueue("1");
		}
		assertTrue(this.myQueue.isFull());
	}

	@Test
	void testSize()
	{
		myQueue.dequeueAll();
		assertEquals(0, myQueue.size());
		myQueue.enqueue("1");
		myQueue.enqueue("2");
		myQueue.enqueue("3");
		assertEquals(3, myQueue.size());
	}

}
