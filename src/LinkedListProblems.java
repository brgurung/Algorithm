import java.util.HashMap;

public class LinkedListProblems {

	class Node
	{
		Integer data;
		Node next;
		
		Node(Integer data)
		{
		    this.data = data;
		}
	}
	


	Node head;

    // add at the end of the list
    void add(Integer data)
    {
    	Node myNode = new Node(data);
    	
    	if (head == null)
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
	   
    void addFirst(Integer data)
    {
    	Node myNode = new Node(data);
 
    	if (head == null)
    	{
    		head = myNode;
    	}
    	else
    	{
    		myNode.next = head;
    		head = myNode;
    	}
    }

    Node getHead()
    {
    	return head;
    }

    // remove duplicate from the linkedlist
	private void removeDuplicate()
	{
		if ((head == null) || (head.next == null))
		{
			System.out.println("Head is NULL or only one Node exists!");
			return;
		}
		
		HashMap<Integer, Integer> checkMap = new HashMap<>();
		
		Node curNode = head;
		Node prevNode = null;
		
		while (curNode != null)
		{
			if (checkMap.containsKey(curNode.data) == true)
			{
				prevNode.next = curNode.next;
				curNode.next = null;
				curNode = prevNode.next;
			}
			else
			{
				checkMap.put(curNode.data, 1);
				prevNode = curNode;
				curNode = prevNode.next;
			}
		}
	}
	
	// find Kth to Last elements from Linked List
    int findKthUtil(Node curNode, int k, int nodeCount)
    {
    	if (curNode == null)
    	{
    		return 0;
    	}
    	
    	int retVal = findKthUtil(curNode.next, k, nodeCount + 1) + 1;

    	if (retVal == k)
    	{
    		System.out.printf("%nKth node is: %d%n", curNode.data);
    	}
    	
    	return retVal;
    }

    void findKthRecursive(int k)
	{
		findKthUtil(head, k, 0);
	}

    void findKthIterative(int k)
    {
    	if ((head == null) || (k <= 0))
    	{
    		System.out.println("Node is NULL");
    		return;
    	}
    	
    	Node curNode = head;
    	Node ffNode = head;
    	
    	for(int i = 0; i < k; i++)
    	{
    		ffNode = ffNode.next;
    		if (ffNode == null)
    		{
    			System.out.println("K elements not in linkedlist!");
    			return;
    		}
    	}
    	
    	while(ffNode != null)
    	{
    		curNode = curNode.next;
    		ffNode = ffNode.next;
    	}
    	
    	System.out.println("Kth element is: " + curNode.data);
    }

    // Sum two linked list
    // 7 -> 1 -> 6 + 5 -> 9 -> 4 = 2 -> 1 -> 1 -> 1
    // 617 + 495 = 1112
    static Node  sumLinkedList(Node node1, Node node2)
    {
    	if ((node1 == null) && (node2 == null))
    	{
    		return null;
    	}
    	
    	if (node1 == null)
    	{
    		return node2;
    	}
    	
    	if (node2 == null)
    	{
    		return node1;
    	}

    	LinkedListProblems sumList = new LinkedListProblems();
        
        int carryOver = 0;
        int sum = 0;
        while( (node1 != null) || (node2 != null))
        {
        	sum = carryOver;
        	
        	if (node1 != null)
        	{
        		sum += node1.data;
        		node1 = node1.next;
        	}
        	
        	if (node2 != null)
        	{
        		sum += node2.data;
        		node2 = node2.next;
        	}
        	
        	if (sum >= 10)
        	{
        		carryOver = sum / 10;
        		sum = sum % 10;
        	}
        	else
        	{
        		carryOver = 0;
        	}
        	
        	sumList.add(sum);
  	
        }

        if (carryOver > 0)
        {
        	sumList.add(carryOver);
        }
        
        return sumList.getHead();
    }

    
    void printList()
	{
		Node temp = head;
		
		while (temp != null)
		{
			System.out.printf("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
    
    static void printList(Node node)
	{
		while (node != null)
		{
			System.out.printf("%d ", node.data);
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		LinkedListProblems myList = new LinkedListProblems();
		
		myList.removeDuplicate();

		myList.add(2);
		myList.removeDuplicate();

		myList.add(9);
		myList.add(7);
		myList.add(9);
		myList.add(12);
		myList.add(11);
		myList.add(13);
		
		System.out.println("Input List: ");
		myList.printList();
		
/*		
		myList.removeDuplicate();
		System.out.println();
		System.out.println("After removing duplicate: ");
		myList.printList();
*/		

		System.out.println();

		// Find Kth node from last
		myList.findKthIterative(0);
				
		myList.findKthIterative(12);
		
		myList.findKthIterative(2);
		
		
		LinkedListProblems node1 = new LinkedListProblems();
		node1.add(7);
		node1.add(1);
		node1.add(6);
		node1.printList();

		LinkedListProblems node2 = new LinkedListProblems();

		System.out.println("Sum of null and 7->1->6 :");
		printList(sumLinkedList(node1.getHead(), node2.getHead()));
		
		node2.add(4);
		System.out.println("Sum of 4 and 7->1->6 :");
		printList(sumLinkedList(node1.getHead(), node2.getHead()));
		
		node2.add(9);
		node2.add(5);
		System.out.println("Sum of 4->9->5 and 7->1->6 :");
		printList(sumLinkedList(node1.getHead(), node2.getHead()));
		
	}
}
