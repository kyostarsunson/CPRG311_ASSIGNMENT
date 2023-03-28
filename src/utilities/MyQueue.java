package utilities;

import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E>, Iterator<E>
{
	private MyDLL<E> myDLL = null;
	private int maxSize = 100;
	private EmptyQueueException emptyQueueException = new EmptyQueueException("empty DLL");

//	public MyDLL<E> getMyDLL()
//	{
//		return myDLL;
//	}

	public MyQueue()
	{
		// TODO Auto-generated constructor stub
		myDLL = new MyDLL<>();
	}

	/**
	 * Returns <code>true</code> if the iteration has more elements. (In other words, returns <code>true</code> if <code>next()</code> would return an
	 * element rather than throwing an exception.)
	 * 
	 * @return <code>true</code> if the iterator has more elements.
	 */
	@Override
	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return myDLL.MyIterator.hasNext();
	}

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return The next element in the iteration.
	 * 
	 * @throws NoSuchElementException If the iteration has no more elements.
	 */
	@Override
	public E next() throws NoSuchElementException
	{
		// TODO Auto-generated method stub
		return (E) myDLL.MyIterator.next();
	}

	/**
	 * Enqueue will place the added item at the last position in the queue. This method will not allow <code>null</code> values to be added to the Queue.
	 * 
	 * @param toAdd the item to be added to the Queue.
	 * 
	 * @throws NullPointerException raised when a <code>null</code> object is placed in the Queue.
	 */
	@Override
	public void enqueue(E toAdd) throws NullPointerException
	{
		// TODO Auto-generated method stub
		if (toAdd.toString() != "")
			myDLL.add(toAdd);
	}

	/**
	 * Dequeue will remove the first item that was placed in the Queue.
	 * 
	 * @return the first item in the Queue.
	 * 
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Override
	public E dequeue() throws EmptyQueueException
	{
		// TODO Auto-generated method stub
		return myDLL.remove(1);
	}

	/**
	 * Peek provides a reference to the first item in the queue without removing from the queue.
	 * 
	 * @return the first item in the queue.
	 * 
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Override
	public E peek() throws EmptyQueueException
	{
		// TODO Auto-generated method stub
		return myDLL.get(1);
	}

	/**
	 * dequeueAll removes all items in the queue.
	 */
	@Override
	public void dequeueAll()
	{
		// TODO Auto-generated method stub
		this.myDLL.clear();
	}

	/**
	 * Returns <code>true</code> when the queue contains no items.
	 * 
	 * @return <code>true</code> when queue length is zero (0).
	 */
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		if (myDLL.size() > 0)
			return false;
		else
		{
			return true;
		}
	}

	/**
	 * Returns an iterator over the elements in this queue in proper sequence.
	 * 
	 * @return an iterator over the elements in this queue in proper sequence.
	 */
	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub

		return myDLL.iterator();
	}

	/**
	 * Used to compare two Queue ADT's. To be equal two queues must contain equal items appearing in the same order.
	 * 
	 * @param that the Queue ADT to be compared to this queue.
	 * 
	 * @return <code>true</code> if the queues are equal.
	 */
	@Override
	public boolean equals(QueueADT<E> that)
	{
		boolean ifEqual = true;
		// TODO Auto-generated method stub
		if (that.size() != this.myDLL.size())
			ifEqual = false;
		else
		{

			Object[] targetArray = that.toArray();
			Object[] oriArray = myDLL.toArray();

			for (int i = 0; i < that.size(); i++)
			{
				if (targetArray[i].equals(oriArray[i]) == false)
				{
					ifEqual = false;
					break;
				}
			}
		}
		return ifEqual;

	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper sequence.
	 */
	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return myDLL.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[]) method.
	 * 
	 * @param holder the array into which the elements of this queue are to be stored, if it is big enough; otherwise, a new array of the same runtime
	 *               type is allocated for this purpose.
	 * 
	 * @return an array containing the elements of this queue.
	 * 
	 * @throws NullPointerException if the specified array is null.
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException
	{
		// TODO Auto-generated method stub

		Object[] stringArray = new Object[myDLL.size()];

		stringArray = myDLL.toArray((E[]) stringArray);

		return (E[]) stringArray;
	}

	/**
	 * (Optional Method) Returns true if the number of items in the queue equals the max size. This operation is only implement when a fixed length queue
	 * is required.
	 * 
	 * @return <code>true</code> if queue is at capacity.
	 */
	@Override
	public boolean isFull()
	{
		// TODO Auto-generated method stub
		if (this.size() >= maxSize)
			return true;
		else
		{
			return false;
		}
	}

	/**
	 * Returns the length of the current queue as an integer value.
	 * 
	 * @return the current size to the queue as an integer.
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub

		return myDLL.size();
	}

}
