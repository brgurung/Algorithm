
public class MyLinkedList {

	private class Node
	{
		Integer data;
		Node next;
		
		Node(Integer data)
		{
			this.data = data;
			next = null; // this is by default
		}
	}
	
	Node head = null;
	
    boolean isEmpty()
    {
    	return (head == null);
    }
	
    void displayList()
    {
        displayList(head);
    }
    
    void displayList(Node head)
    {
        if (head == null)
        {
        	System.out.println("HEAD is NULL!");
        }
        else
        {
        	int index = 0; // cannot declare different variable as for loop initializer
        	for (Node temp = head; temp != null; temp = temp.next, index++)
        	{
        		System.out.printf("%n Index: %d Data: %d %n", index, temp.data.intValue());
        	}
        }
    }

    // add at the end of the list
    void add(Integer data)
    {
    	Node myNode = new Node(data);
    	
    	if (isEmpty())
    	{
    		head = myNode;
    	}
    	else
    	{
    		Node temp = head;
    		for(; temp.next != null; temp = temp.next);
    		
    		temp.next = myNode;
    	}
    	
    }
	
    boolean add(int index, Integer data)
    {
    	boolean retVal = true;
		Node myNode = new Node(data);
		
		if (index == 0)
		{
			myNode.next = head.next;
			head = myNode;
			retVal = true;
		}
		else
		{
			Node temp = null;
			int i = 0;
			for (temp = head; (i < index - 1)  && (temp != null); temp = temp.next, i++);
    	
    	if ((i == index - 1) && (temp != null))
    	{

    		myNode.next = temp.next;
    		temp.next = myNode;
    		retVal = true;
    	}
    	else
    	{
    		System.out.println("Not able to add node at Index " + index);
    		retVal = false;
    	}
		}
    	return retVal;
    }
	
    int find(Integer data)
    {
    	int index = 0;

    	if (head == null)
    	{
    		index = -1;
    	}
    	else
    	{
    		Node temp = null;
    		for (temp = head; temp != null; temp = temp.next, index++)
    		{
    			if (temp.data.equals(data))
    			{
    				break;
    			}
    		}
    		
    		if (temp == null)
    		{
    			index = -1;
    		}
    	}
		
		return index;
    }
    
    void reverseList(Node ref1, Node ref2)
    {
    	// base case
    	if (ref2.next == null)
    	{
    		ref2.next = ref1;
    		ref1.next = null;
    		head = ref2;
    	}
    	else
    	{
    		reverseList(ref2, ref2.next);
    		ref2.next = ref1;
    		ref1.next = null;
    	}
    }

    void reverseRecursive()
    {
    	if ((head == null) || (head.next == null))
    	{
    		System.out.println("No need to reverse Linked list!");
    		return;
    	}
    	else
    	{
    		reverseList(head, head.next);
    	}
    }

    
    void reverseIterative()
    {
    	Node curNode = head;
    	Node nextNode = null;
    	Node prevNode = null;
    	
    	while (curNode != null)
    	{
    		nextNode = curNode.next;
    		curNode.next = prevNode;
    		prevNode = curNode;
    		curNode = nextNode;
    	}
    	
    	head = prevNode;
   	
    }
  
    Node splitInHalf()
    {
    	Node newNode = null;
    	
    	if (isEmpty())
    	{
    		newNode = null;
    	}
    	else
    	{
    		Node headNode = head;
    		Node tailNode = head.next;
    	
    		while ((tailNode != null) && (tailNode.next != null))
    		{
    			headNode = headNode.next;
    			tailNode = tailNode.next.next;
    		}
    		
    		newNode = headNode.next;
    		headNode.next = null;
    	}

    	return newNode;
    }

    public static void main(String[] args)
	{
		MyLinkedList myList = new MyLinkedList();
		
		myList.add(12);
		myList.add(1);
		myList.add(22);
		myList.add(32);
		myList.add(54);

		myList.displayList();
		
		myList.add(0, 7);
		myList.add(20, 3);
		myList.add(3, 4);
		
		myList.displayList();
	
		int index = myList.find(22);
		System.out.printf("%n Element 22 is at index %d", index);
		
		index = myList.find(17);
		System.out.printf("%n Element 17 is at index %d %n", index);
		
		myList.reverseRecursive();
		System.out.println("After reversing: ");
		myList.displayList();
		
		myList.reverseIterative();
		System.out.println("After iterative reversal: ");
		myList.displayList();

		myList.add(7);

		Node newHead = myList.splitInHalf();
	    System.out.println("After splitting: ");
	    System.out.println("List1: ");
	    myList.displayList();
	    System.out.println("List2: ");
	    myList.displayList(newHead);
	}
}
