package utilities;

/**
 * MyDLLNode.java
 * 
 * @author Songlie xu
 *
 * @version Mar. 27, 2023
 * 
 * @description: this class is designed Node to store data for all of our ADT.
 */
public class MyDLLNode<T>
{
	private T nodeContent;

	/**
	 * @return the node data contend.
	 */
	public T getNodeContent()
	{
		return nodeContent;
	}

	/**
	 * @param nodeContent.
	 * 
	 * @function set the node content.
	 */
	public void setNodeContent(T nodeContent)
	{
		this.nodeContent = nodeContent;
	}

	private MyDLLNode<T> nextNode;

	public MyDLLNode(T myNodeContent)
	{
		this.nodeContent = myNodeContent;
		this.nextNode = null;
	}

	/**
	 * @return get the next Node and return.
	 */
	public MyDLLNode<T> getNextNode()
	{
		return nextNode;
	}

	/**
	 * @param set the next nextnode.
	 */
	public void setNextNode(MyDLLNode<T> nextNode)
	{
		this.nextNode = nextNode;
	}

}
