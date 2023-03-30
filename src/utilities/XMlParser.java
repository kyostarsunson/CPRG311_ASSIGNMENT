package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import exceptions.EmptyQueueException;

/**
 * xMlParser.java
 * 
 * @author Songlie xu
 *
 * @version Mar. 27, 2023
 * 
 * @description:
 */
public class XMlParser
{

	/**
	 * @param args
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @function describe: Main function
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// 1. read supplied the XML document by the command line
		String fileNameString = args[0];
		// 2. doing the parser and show result.
		System.out.println("Target XMl file is :" + fileNameString + "\n");
		String myString = readFile(fileNameString);
		System.out.println("XML contend is:\n" + myString);
		try
		{
			Parser(myString);
		} catch (EmptyQueueException e)
		{
			e.printStackTrace();
		}
		System.out.println("\nEnd of parcer process.\n\n\n");
	}

	/**
	 * @param fileName: it is the target XML file name.
	 * 
	 * @return : the XML contend read.
	 */
	public static String readFile(String fileName)
	{
		String fileContentString = "";
		try
		{
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				fileContentString += line;
			}
			// close resources
			br.close();
			fr.close();
		} catch (Exception e)
		{
			System.err.println("no file");
		}
		return fileContentString;
	}

	/**
	 * this function allow read a string and processing matching. The action will read by character. Every character have 2 status: in tag true or false.
	 * Total have special characterS: < > / ' ', and normal character . Totally: consider read special character in different status do the following
	 * action.
	 * 
	 * @param targetString: it is the HTML format text.
	 */
	public static void Parser(String targetString) throws EmptyQueueException
	{
		MyStack<Character> tagCharacterStack = new MyStack<>();
		int tagLength = 0;
		String tagReaded = "";

		MyStack<String> tagStack = new MyStack<>();

		char[] inputCharArray = targetString.toCharArray();
		boolean ifInTag = false;
		boolean ifTagHaveBlank = false;
		String rootTag = "";

		// String notTagString = "";
		// MyQueue<Character> notTagStringQ = new MyQueue<>();
		MyQueue<String> errorQ = new MyQueue<>();
		MyQueue<String> extrasQ = new MyQueue<>();

		// 0. read string by character
		for (char i : inputCharArray)
		{

			// 1. if read special character: tag's begin character <
			if (i == '<')
			{
				if (ifInTag == false)
				{
					ifInTag = true;
					while (tagCharacterStack.peek() != null)
					{
						tagReaded = tagCharacterStack.pop().toString() + tagReaded;
					}
					tagStack.push(tagReaded);

					tagCharacterStack.push('<');
					tagLength = 1;

					tagReaded = "";
					ifTagHaveBlank = false;
				} else
				{
					extrasQ.enqueue(String.valueOf(i));
				}

			}
			// 2. if read normal character in a tag, begin to create tag.
			if ((i != '<') && (i != '>'))
			{
				if (ifInTag == true)
				{
					// 2.1 if this character is space then set the break switch .
					if (i == ' ')
						ifTagHaveBlank = true;

					// 2.2 if break switch off or read / must push to tag character stake.
					if (ifTagHaveBlank == false || i == '/')
					{
						tagCharacterStack.push(i);
						tagLength++;
					}
				} else
				{
					tagCharacterStack.push(i);
					tagLength++;
				}
			}
			// System.out.println("tagLength=" + tagLength);
			// System.out.println("ifInTag=" + ifInTag);

			// 3. if read a tag's end character
			if ((i == '>'))
			{
				if (ifInTag == true)
				{
					tagCharacterStack.push('>');
					tagLength++;

					// 3.0 pop and formed the tag and push to the tag Stack.
					for (; tagLength > 0; tagLength--)
					{
						tagReaded = tagCharacterStack.pop().toString() + tagReaded;
					}

					// System.out.println("tagReaded=" + tagReaded);
					// 3.1 if it is a open or close tag ,push to stack.
					if (rootTag == "" && tagReaded.equals("<?xml>") == false)
						rootTag = tagReaded;
					tagStack.push(tagReaded);

					// 4.0 end the tag process status;
					ifInTag = false;

					// 5.1 if it is end_tag , the extra action is to find the start_tag.( there are two kinds of end tag, one is self closing tag; the other is normal end
					// tag.
					if (tagReaded.equals("<?xml>"))
						tagStack.pop();

					if (tagReaded.indexOf("/") > 0)
					{
						String openTagString = "<" + tagReaded.substring(2, tagReaded.length());
						tagStack.pop(); // pop this end tag.
						// 5.2.1 check if the top of tag stack can match the end tag?

						// 5.2.1 if it is Self_Closing_Tag, ignore(match); if tagStack is null, add to errorQ(mismatch); if first tag match, pop the start tag. If the other
						// match, enqueue to
						// error; If
						// mismatch, enqueue to extraQ
						if (tagReaded.indexOf("/>") >= 0)
						{
							// self close tag, ignore.
						} else if (tagStack.size() == 0)
						{
							// stack is null, add to error.
							errorQ.enqueue(tagReaded);
						} else
						{
							// 5.2.1.1 Search stack for matching Start_Tag If stack has match，Pop each E from stack into errorQ until match, report as error
							boolean ifHaveMatchTag = false;
							int tagNO = 0;
							Iterator<String> stackIterator = tagStack.iterator();

							// Search stack for matching Start_Tag
							while (stackIterator.hasNext())
							{
								String readStringFromStack = stackIterator.next().toString();
								if (readStringFromStack.indexOf("<") >= 0)
								{
									tagNO++;
									if (readStringFromStack.equals(openTagString))
									{
										ifHaveMatchTag = true;
										if (tagNO == 1)
										{
											// if match top of stack, pop all tag until start tag
											while (tagStack.peek().equals(openTagString) == false)
											{
												tagStack.pop();
											}
											tagStack.pop();
										} else
										{
											// if match not top of stack, pop all tag until start tag
											errorQ.enqueue(tagReaded);

											while (tagStack.peek().equals(openTagString) == false)
											{
												errorQ.enqueue(tagStack.pop());
											}
											errorQ.enqueue(tagStack.pop());
										}
										break;
									}
								}

							}

							if (ifHaveMatchTag == false)
							{
								extrasQ.enqueue(tagReaded);
							}
						}
					}
					// 6. after read close character >, clear tag read variable.
					tagLength = 0;
					tagReaded = "";
					ifTagHaveBlank = false;
					// notTagString = "";
				} else
				{

					extrasQ.enqueue(String.valueOf(i));
					ifInTag = false;
				}
			}
		}

		// If stack is not empty, pop each E into errorQ
		while (tagStack.peek() != null)
			errorQ.enqueue(tagStack.pop());

		// System.err.println("show rest of tagCharacterStack1: " + tagCharacterStack.getMyArrayList().toString());
		// System.err.println("show rest of tagStack: " + tagStack.getMyArrayList().toString() + "\n");

		System.err.println("--------------------------------------------------------------------------------------------");
		System.err.println("Error List:");
		// 0. Root tag number error:
		// System.out.println("rootTag" + rootTag);
		if (rootTag.equals(""))
		{
			System.err.println("root tag missing");
		} else
		{
			int rootTagCnt = 0;
			int indexFind = 0;
			while ((indexFind = targetString.indexOf(rootTag, indexFind)) > 0)
			{
				indexFind = indexFind + rootTag.length();
				rootTagCnt++;
			}
			if (rootTagCnt > 1)
				System.err.println("* More than 1 root tag. Root tag=" + rootTag);
		}

		// 1. If either queue is empty (but not both), report each E in both queues as error
		if (extrasQ.isEmpty() && !errorQ.isEmpty())
		{
			System.err.println("* extrasQ is empty. errorQ is not empty.");
			while (errorQ.peek() != null)
			{
				System.err.print("_" + errorQ.dequeue() + "_");
			}
		}
		// 1. If either queue is empty (but not both), report each E in both queues as error
		if (!extrasQ.isEmpty() && errorQ.isEmpty())
		{
			System.err.println("* extrasQ is not empty. errorQ is empty.");
			while (extrasQ.peek() != null)
			{
				System.err.print(extrasQ.dequeue());
			}
		}
		// If both queues are not empty, peek both queues If they don’t match, dequeue from errorQ and report as error Else dequeue from both
		if (!extrasQ.isEmpty() && !errorQ.isEmpty())
		{
			if (extrasQ.peek().equals(errorQ.peek()))
			{
				System.out.println("* extrasQ is not empty  errorQ is not empty. And match.");
				while (errorQ.peek() != null)
				{
					System.err.print(errorQ.dequeue());
				}
			} else
			{
				System.err.println("* extrasQ is not empty. errorQ is not empty. And mismatch.");
				System.err.println("---- errorQ is");
				while (errorQ.peek() != null)
				{
					System.err.print(errorQ.dequeue());
				}

				System.err.println("\n");
				System.err.println("---- extrasQ is");
				while (extrasQ.peek() != null)
				{
					System.err.print(extrasQ.dequeue());
				}
			}
		}
	}

}
