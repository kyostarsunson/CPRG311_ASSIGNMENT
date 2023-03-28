package exceptions;

public class EmptyQueueException extends Exception
{
	private static final long serialVersionUID = -8362167508526799123L;

	public EmptyQueueException()
	{
	}

	public EmptyQueueException(String meString)
	{
		super(meString);
	}
}
