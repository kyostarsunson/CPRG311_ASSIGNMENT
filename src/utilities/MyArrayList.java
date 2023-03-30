package utilities;

import java.util.NoSuchElementException;

/**
 * MyArrayList.java
 * 
 * @author Songlie xu
 *
 * @version Mar. 27, 2023
 * 
 * @description This class is define my ArrayList and the common function.
 */
public class MyArrayList<E> implements ListADT<E>
{
	private Object[] contend;
	private int maxCnt = 0;
	private int capacity = 10;
	myIterator MyIterator;

	class myIterator implements Iterator<E>
	{
		private int currentIndex = 0;

		/**
		 * Returns <code>true</code> if the index has more elements. (In other words, returns <code>true</code> if <code>next()</code> would return an element
		 * rather than throwing an exception.)
		 * 
		 * @return <code>true</code> if the index has more elements.
		 */
		@Override
		public boolean hasNext()
		{
			// System.out.println("in has next, currindex="+currentIndex+" get curreint ");
			// TODO Auto-generated method stub
			if (get(currentIndex + 1) != null)
				return true;
			else
				return false;
		}

		/**
		 * Returns the next element in the index.
		 * 
		 * @return The next element in the index.
		 * 
		 * @throws NoSuchElementException If the iteration has no more elements.
		 */
		@Override
		public Object next() throws NoSuchElementException
		{
			// TODO Auto-generated method stub
			currentIndex = currentIndex + 1;
			return get(currentIndex);
		}

	}

	public MyArrayList()
	{
		contend = new Object[capacity];
	}

	public E[] expand()
	{
		// contend = Arrays.copyOf(contend, contend.length + capacity);
		Object[] newContendArray = new Object[contend.length + capacity];
		for (int i = 0; i < contend.length; i++)
		{
			newContendArray[i] = contend[i];
		}
		contend = newContendArray;
		return (E[]) contend;
	}

	/**
	 * The size method will return the current element count contained in the list.
	 * 
	 * @return The current element count.
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return this.maxCnt;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after this call returns.
	 */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		contend = new Object[capacity];
		maxCnt = 0;
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index The index at which the specified element is to be inserted. The element is inserted before the existing element at [index], or at the
	 *              end if index is equal to the size (<code>size()</code>).
	 * @param toAdd The element to be inserted.
	 * 
	 * @return <code>true</code> if the element is added successfully.
	 * 
	 * @throws NullPointerException      If the specified element is <code>null</code> and the list implementation does not support having
	 *                                   <code>null</code> elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (<code>index < 0 || index > size()</code>).
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		if (contend == null || this.maxCnt >= contend.length)
		{
			expand();
		}
		if (index > this.maxCnt + 1)
		{
			// System.err.println("in add err: index exceed the max range of current list");
			return false;
		} else
		{
			int i = maxCnt;
			for (; i >= index; i--)
			{
				contend[i] = contend[i - 1];
			}
			contend[i] = toAdd;
			maxCnt++;
			return true;
		}
	}

	/**
	 * Appends the specified element to the end of this list. Implementations that support this operation may place limitations on what elements may be
	 * added to this list. In particular, some implementations will refuse to add <code>null</code> elements. List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * @param toAdd Element to be appended to this list.
	 * 
	 * @return true if element is appended successfully.
	 * 
	 * @throws NullPointerException      If the specified element is <code>null</code> and the list implementation does not support having
	 *                                   <code>null</code> elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (<code>index < 0 || index > size()</code>).
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		// System.out.println("in add:
		// this.size="+this.size()+",length="+contend.length);
		if (contend == null || this.maxCnt >= contend.length + 1)
		{
			expand();
		}
		maxCnt++;
		contend[maxCnt - 1] = toAdd;
		return false;
	}

	@Override
	public String toString()
	{
		// System.out.println("in to sTring,size=" + size());
		String aListContentString = "[";
		for (int i = 0; i < this.maxCnt; i++)
			aListContentString += "->" + contend[i].toString();
		aListContentString += "]";
		return aListContentString;
	}

	/**
	 * Appends all of the elements in the specified <code>java.utilCollection</code> to the end of this list, in the order that they are returned by the
	 * specified collection's <code>Iterator</code>. The behaviour of this operation is unspecified if the specified collection is modified while the
	 * operation is in progress. (Note that this will occur if the specified collection is this list, and it's nonempty.)
	 * 
	 * @param toAdd The new sub list to be added.
	 * 
	 * @return true If the operation is successful.
	 * 
	 * @throws NullPointerException If the specified element is <code>null</code> and the list implementation does not support having <code>null</code>
	 *                              elements.
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index Index of element to return.
	 * 
	 * @return The element at the specified position in this list.
	 * 
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		return (E) contend[index - 1];
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 * 
	 * @param index The index of the element to remove.
	 * 
	 * @return The removed element.
	 * 
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (index > this.maxCnt)
		{
			// System.err.println("in add err: index exceed the max range of current list, return null");
			return null;
		} else
		{
			int i = index - 1;
			E delectNodE = (E) contend[index - 1];
			for (; i < this.maxCnt - 1; i++)
			{
				contend[i] = contend[i + 1];
			}
			contend[i] = null;
			maxCnt--;
			return delectNodE;
		}
	}

	/**
	 * Removes the first occurrence in this list of the specified element. If this list does not contain the element, it is unchanged. More formally,
	 * removes the element with the lowest index <code>i</code> such that <code>o.equals(get(i))</code> (if such an element exists).
	 * 
	 * @param toRemove The element to be removed from this list.
	 * 
	 * @return The element which is being removed, or null if the list does not contain the element.
	 * 
	 * @throws NullPointerException If the specified element is <code>null</code> and the list implementation does not support having <code>null</code>
	 *                              elements.
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException
	{
		E removE = null;
		// TODO Auto-generated method stub
		for (int i = 1; i <= maxCnt; i++)
		{
			if (removE != null && i < maxCnt)
				contend[i - 1] = contend[i];

			if (removE == null && contend[i - 1].equals(toRemove))
			{
				removE = (E) contend[i - 1];
				contend[i - 1] = contend[i];
			}
		}
		maxCnt--;
		return removE;
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index    The index of the element to replace.
	 * @param toChange Element to be stored at the specified position.
	 * 
	 * @return The element previously at the specified position.
	 * 
	 * @throws NullPointerException      If the specified element is <code>null</code> and the list implementation does not support having
	 *                                   <code>null</code> elements.
	 * @throws IndexOutOfBoundsException If the index is out of range: i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{
		// TODO Auto-generated method stub
		if (index > this.maxCnt)
		{
			// System.err.println("in add err: index exceed the max range of current list");
			return null;
		} else
		{
			contend[index - 1] = toChange;
			return (E) contend[index - 1];
		}
	}

	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		if (this.maxCnt <= 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element
	 * <code>e</code> such that <code>toFind.equals(e)</code>.
	 * 
	 * @param toFind The element whose presence in this list is to be tested.
	 * 
	 * @return <code>true</code> if this list contains the specified element.
	 * 
	 * @throws NullPointerException If the specified element is <code>null</code> and the list implementation does not support having <code>null</code>
	 *                              elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException
	{
		// TODO Auto-generated method stub

		boolean isFound = false;
		// TODO Auto-generated method stub
		for (int i = 1; i <= maxCnt; i++)
		{
			if (isFound != true && i <= maxCnt && contend[i - 1].equals(toFind))
			{
				isFound = true;
				break;
			}
		}

		return isFound;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param toHold The array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type
	 *               is allocated for this purpose.
	 * 
	 * @return An array containing the elements of this list.
	 * 
	 * @throws NullPointerException If the specified array is <code>null</code>.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException
	{
		// TODO Auto-generated method stub
		Object[] returnArray = new Object[this.maxCnt];

		for (int i = 0; i < this.maxCnt; i++)
			returnArray[i] = contend[i];
		return (E[]) returnArray;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence. Obeys the general contract of the
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this list in proper sequence.
	 */
	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return contend;
	}

	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence. NB: The return is of type <code>linearUtilities.Iterator<E></code>, not
	 *         <code>java.util.Iterator</code>.
	 */
	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		MyIterator = new myIterator();
		return MyIterator;
	}
}
