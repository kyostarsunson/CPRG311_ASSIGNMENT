package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * MyStack.java
 * 
 * @author Songlie xu
 *
 * @version Mar. 27, 2023
 */
public class MyStack<E> implements StackADT<E>, Iterator<E>
{
	private MyArrayList<E> myArrayList;

	@SuppressWarnings("unchecked")
	public MyStack()
	{

		myArrayList = new MyArrayList<>();
		// System.out.println(e.getClass());
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param toAdd item to be pushed onto the top of the stack.
	 * 
	 * @throws NullPointerException when attempting to add a null element to the stack.
	 */
	@Override
	public void push(E toAdd) throws NullPointerException
	{
		// TODO Auto-generated method stub
		this.myArrayList.add(1, toAdd);
	}

	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * 
	 * @return the item popped off the top of the stack.
	 * 
	 * @throws EmptyStackException if there are not items in the stack.
	 */
	@Override
	public E pop() throws EmptyStackException
	{
		// TODO Auto-generated method stub
		return this.myArrayList.remove(1);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * 
	 * @return the object at the top of this stack.
	 * 
	 * @throws EmptyStackException
	 */
	@Override
	public E peek() throws EmptyStackException
	{
		// TODO Auto-generated method stub544

		return this.myArrayList.get(1);

	}

	/**
	 * Clears all the items from this Stack. This method returns, unless there is an Exception (Runtime) thrown.
	 */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		myArrayList.clear();
	}

	/**
	 * Returns <code>true</code> if this Stack contains no items.
	 * 
	 * @return <code>true</code> if this Stack contains no items.
	 */
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		if (myArrayList.size() == 0)
			return true;
		else
			return false;
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
		return myArrayList.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[]) method.
	 * 
	 * @param toHold the array into which the elements of this stack are to be stored, if it is big enough; otherwise, a new array of the same runtime
	 *               type is allocated for this purpose.
	 * 
	 * @return an array containing the elements of this stack.
	 * 
	 * @throws NullPointerException if the specified array is null.
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return myArrayList.toArray(holder);
	}

	/**
	 * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param toFind element whose presence in this list is to be tested.
	 * 
	 * @return true if this list contains the specified element.
	 * 
	 * @throws NullPointerException if the specified element is null and this list does not support null elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return myArrayList.contains(toFind);
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the object o occurs as an item in this stack, this method returns the distance
	 * from the top of the stack of the occurrence nearest the top of the stack; the topmost item on the stack is considered to be at distance 1. The
	 * equals method is used to compare o to the items in this stack.
	 * 
	 * @param toFind the desired object.
	 * 
	 * @return the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	@Override
	public int search(E toFind)
	{
		// TODO Auto-generated method stub

		for (int i = 1; i <= myArrayList.size(); i++)
		{
			if (myArrayList.get(i).equals(toFind.toString()))
			{
				return i;
			}

		}
		return 0;
	}

	/**
	 * Returns an iterator over the elements in this stack in proper sequence.
	 * 
	 * @return an iterator over the elements in this stack in proper sequence.
	 */
	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return myArrayList.iterator();
	}

	/**
	 * Used to compare two Stack ADT's. To be equal two stacks must contain equal items appearing in the same order.
	 * 
	 * @param that the Stack ADT to be compared to this stack.
	 * 
	 * @return <code>true</code> if the stacks are equal.
	 */
	@Override
	public boolean equals(StackADT<E> that)
	{
		boolean ifEqual = true;
		// TODO Auto-generated method stub
		if (that.size() != this.myArrayList.size())
			ifEqual = false;
		else
		{

			Object[] targetArray = that.toArray();
			Object[] oriArray = this.myArrayList.toArray();

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
	 * Returns the depth of the current stack as an integer value.
	 * 
	 * @return the current size to the stack as an integer.
	 */
	@Override
	public int size()
	{

		// TODO Auto-generated method stub
		return myArrayList.size();
	}

	public MyArrayList<E> getMyArrayList()
	{
		return myArrayList;
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

		return myArrayList.iterator().hasNext();
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
		return (E) myArrayList.iterator().next();
	}

}
