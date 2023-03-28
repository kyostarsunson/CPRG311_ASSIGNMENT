package utilities;

import java.util.NoSuchElementException;

/**
 * MyDLL.java
 * 
 * @author Songlie xu
 *
 * @version Mar. 27, 2023
 * 
 * @description: This class is the definison
 */
public class MyDLL<E> implements ListADT<E>, Iterator<E>
{
	private MyDLLNode<E> headNode;
	myIterator MyIterator = new myIterator();

	class myIterator implements Iterator<E>
	{
		private int currentIndex = 0;

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

		@Override
		public Object next() throws NoSuchElementException
		{
			// TODO Auto-generated method stub
			if (hasNext())
			{
				currentIndex++;
				return get(currentIndex);
			} else
			{
				return null;
			}
		}

	}

	public MyDLL()
	{
		this.headNode = null;
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
		MyDLLNode<E> currentDllNode = headNode;
		int size = 0;

		while (currentDllNode != null)
		{
			size++;
			currentDllNode = currentDllNode.getNextNode();
		}

		return size;
	}

	/**
	 * Removes all of the elements from this list. This list will be empty after this call returns.
	 */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		if (this.size() > 0)
			this.headNode = null;
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
		// 1. allow to add in the tail of myDLL
		if (index > this.size() + 1 || index <= 0)
		{
			System.out.println("index: " + index + " out of range");

			return false;
		} else
		{
			MyDLLNode<E> addNode = new MyDLLNode(toAdd);

			if (index == 1)
			{
				addNode.setNextNode(this.headNode);
				this.headNode = addNode;
			} else
			{
				MyDLLNode<E> currentDllNode = this.headNode;

				for (int currentIndex = 1; currentIndex <= index - 2; currentIndex++)
				{
					currentDllNode = currentDllNode.getNextNode();
				}

				addNode.setNextNode(currentDllNode.getNextNode());
				currentDllNode.setNextNode(addNode);

			}
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
		try
		{
			MyDLLNode<E> addNode = new MyDLLNode(toAdd);

			if (this.size() == 0)
			{

				this.headNode = addNode;

			} else
			{

				MyDLLNode<E> currentDllNode = this.headNode;

				for (int currentIndex = 1, dllSize = this.size(); currentIndex <= dllSize - 1; currentIndex++)
				{
					currentDllNode = currentDllNode.getNextNode();
				}

				currentDllNode.setNextNode(addNode);

			}

			// System.out.println(this.toString());
			return true;
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("error");
			return false;
		}

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
		// Note: legal index is [1:size]
		MyDLLNode<E> currentDllNode = headNode;
		int currentIndex = 1;

		if (index > this.size() || index <= 0)
		{
			// System.out.println("index: " + index + " is out of range.");
			return null;
		} else
		{
			while (currentIndex != index)
			{
				currentDllNode = currentDllNode.getNextNode();
				currentIndex++;
			}
			return currentDllNode.getNodeContent();
		}
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

		if (index > this.size() || index <= 0)
		{
			System.out.println("index: " + index + " out of range");
			return null;
		} else
		{
			MyDLLNode<E> currentDllNode = this.headNode;

			if (index == 1)
			{
				this.headNode = this.headNode.getNextNode();
			} else
			{
				for (int currentIndex = 1; currentIndex < index - 1; currentIndex++)
				{
					currentDllNode = currentDllNode.getNextNode();
				}
				currentDllNode.setNextNode(currentDllNode.getNextNode().getNextNode());
			}
			return currentDllNode.getNodeContent();
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
		// TODO Auto-generated method stub
		MyDLLNode<E> currentDllNode = this.headNode;
		E removeE = null;

		if (this.headNode.getNodeContent().equals(toRemove))
		{
			removeE = this.headNode.getNodeContent();
			this.headNode = this.headNode.getNextNode();
		} else
		{
			while (currentDllNode.getNextNode() != null)
			{
				if (currentDllNode.getNextNode().getNodeContent().equals(toRemove) == false)
					currentDllNode = currentDllNode.getNextNode();
				else
				{
					removeE = currentDllNode.getNextNode().getNodeContent();
					currentDllNode.setNextNode(currentDllNode.getNextNode().getNextNode());
				}
			}
		}
		return removeE;
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
		if (this.size() == 0)
			return true;
		else
			return false;
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
		// int currentPo = 1;

		MyDLLNode<E> toChangeNode = new MyDLLNode<>(toChange);
		MyDLLNode<E> currentDllNode = this.headNode;

		if (index > this.size())
		{
			return null;
		}

		if (index == 1)
		{
			toChangeNode.setNextNode(this.headNode.getNextNode());
			this.headNode = toChangeNode;
		} else
		{
			for (int currentPo = 1; currentPo <= index - 2; currentPo++)
			{
				currentDllNode = currentDllNode.getNextNode();
			}
			toChangeNode.setNextNode(currentDllNode.getNextNode().getNextNode());
			currentDllNode.setNextNode(toChangeNode);
		}
		return toChangeNode.getNodeContent();
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
		MyDLLNode<E> currentDllNode = this.headNode;
		for (int currentIndex = 1, dllSize = this.size(); currentIndex <= dllSize; currentIndex++)
		{
			if (currentDllNode.getNodeContent().toString().equals(toFind.toString()))
			{
				return true;
			} else
			{
				currentDllNode = currentDllNode.getNextNode();
			}
		}

		return false;
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
		Object[] myArrayObject = new Object[this.size()];

		if (this.size() == 0)
			return null;
		else
		{
			myArrayObject = new Object[this.size()];
			for (int i = 0; i < this.size(); i++)
				myArrayObject[i] = this.get(i + 1);
		}
		return myArrayObject;
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

		return MyIterator.hasNext();
	}

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return The next element in the iteration.
	 * 
	 * @throws NoSuchElementException If the iteration has no more elements.
	 */
	@Override
	public Object next() throws NoSuchElementException
	{
		// TODO Auto-generated method stub
		return MyIterator.next();
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
		// TODO Auto-generated method stub
		// toHold = new E[this.size()];

		if (this.size() == 0)
			return null;
		else
		{
			// toHold = new E[this.size()];
			for (int i = 0; i < this.size(); i++)
				toHold[i] = this.get(i + 1);
		}
		return toHold;

	}

	@Override
	public String toString()
	{
		if (this.size() == 0)
			return "[]";
		else
		{
			MyDLLNode<E> currentDllNode = headNode;
			String dLLContent = "[" + currentDllNode.getNodeContent().toString();

			while (currentDllNode.getNextNode() != null)
			{
				currentDllNode = currentDllNode.getNextNode();
				dLLContent += "" + currentDllNode.getNodeContent();
			}

			dLLContent += "]";
			return dLLContent;
		}
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
