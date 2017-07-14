import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Random;

public class BinaryTree {

	class Node
	{
		int data;
		Node left;
		Node right;
		Node parent;
		
		Node(int data)
		{
			this.data = data;
		}
	}

	Node root;
	
	void addNode(int data)
	{
		Node newNode = new Node(data);
		
		if (root == null)
		{
			root = newNode;
			System.out.println("Adding root: " + root.data);
		}
		else
		{
			Queue<Node> bfsQueue = new LinkedList<>();
			
			bfsQueue.offer(root);

			while(!bfsQueue.isEmpty())
			{
				Node curNode = bfsQueue.poll();
				
				if(curNode.left == null)
				{
					curNode.left = newNode;
					newNode.parent = curNode;
					System.out.printf("%nAdding node: parent: %d left: %d%n", curNode.data, curNode.left.data);
					break;
				}
				else
				{
					bfsQueue.offer(curNode.left);
				}
				
				if (curNode.right == null)
				{
					curNode.right = newNode;
					newNode.parent = curNode;
					System.out.printf("%nAdding node: parent: %d right: %d%n", curNode.data, curNode.right.data);
					break;
				}
				else
				{
					bfsQueue.offer(curNode.right);
				}
					
			}
		}
	}


	Node getRoot()
	{
		return root;
	}
    ///////////////////////////////////////////////////////////////////
	// Given a binary tree, create linked list of all nodes at each depth
	void listOfNodesDFSUtil(Node curNode, List<List<Node>> masterList, int depth)
	{
		if (curNode == null)
		{
			return;
		}

		if (masterList.size() == depth)
		{
			List<Node> nodeList = new LinkedList<>();
			masterList.add(nodeList);
		}
		
		masterList.get(depth).add(curNode);
		listOfNodesDFSUtil(curNode.left, masterList, depth + 1);
		listOfNodesDFSUtil(curNode.right, masterList, depth + 1);
	}

	
	void listOfNodesDFS(Node root, List<List<Node>> masterList)
	{
		if ((masterList == null) || (root == null))
		{
			return;
		}
		
		listOfNodesDFSUtil(root, masterList, 0);
	}
	
	void listOfNodesBFS(Node root, List<List<Node>> masterList)
	{
		if ((root == null) || (masterList == null))
		{
			return;
		}
		
		List<Node> nodeList = new LinkedList<>();
		nodeList.add(root);
		//System.out.println("Adding root: 0" + root.data);
		while (nodeList.size() > 0)
		{
			masterList.add(nodeList);
			List<Node> parentList = nodeList;
			nodeList = new LinkedList<>();
			
			for (Node curNode : parentList)
			{
				if (curNode.left != null)
				{
					//System.out.println("Adding node left: " + curNode.left.data);
					nodeList.add(curNode.left);
				}
				
				if (curNode.right != null)
				{
					//System.out.println("Adding node right: " + curNode.right.data);
					nodeList.add(curNode.right);
				}
			}
			
			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	// Find in-order successor of a given node
	/////////////////////////////////////////////////////////////////////////////////////
	Node findSuccessor(Node root)
	{
		if (root == null)
			return null;
		
		if (root.right != null)
		{
			return leftMostNode(root.right);
		}
		else
		{
			Node curNode = root;
			Node parent = curNode.parent;
			
			while ((parent != null) && (curNode != parent.left))
			{
				curNode = parent;
				parent = curNode.parent;
			}
			
			return parent;
		}
	}
	
	Node leftMostNode(Node root)
	{
		if (root == null)
			return null;
		
		while (root.left != null)
		{
			root = root.left;
		}
		
		return root;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	// List all the arrays that can form particular binary search tree
	
	void weave(List<Integer> prefix, List<Integer> first, List<Integer> second, List<List<Integer>> weavedList)
	{
		if ((first.size() == 0) || (second.size() == 0))
		{
			List<Integer> newList = new LinkedList<Integer>(prefix);
			newList.addAll(first);
			newList.addAll(second);
			weavedList.add(newList);
			return;
		}

	
		int headFirst = ((LinkedList<Integer>)first).removeFirst();
		prefix.add(headFirst);
		weave(prefix, first, second, weavedList);
		((LinkedList<Integer>)prefix).removeLast();
		((LinkedList<Integer>)first).addFirst(headFirst);
		
		headFirst = ((LinkedList<Integer>)second).removeFirst();
		prefix.add(headFirst);
		weave(prefix, first, second, weavedList);
		((LinkedList<Integer>)prefix).removeLast();
		((LinkedList<Integer>)second).addFirst(headFirst);

	}
	
	List<List<Integer>> bstSrcArray(Node root)
	{
		List<List<Integer>> masterList = new ArrayList<>();
		
		if (root == null)
		{
			masterList.add(new LinkedList<Integer>());
			return masterList;
		}
		
		List<Integer> prefix = new LinkedList<>();
		prefix.add(root.data);
		
		List<List<Integer>> leftList = bstSrcArray(root.left);
		List<List<Integer>> rightList = bstSrcArray(root.right);
		
		for (List<Integer> left : leftList)
		{
			for (List<Integer> right : rightList)
			{
				List<List<Integer>> weavedList = new ArrayList<>();
				weave(prefix, left, right, weavedList);
				masterList.addAll(weavedList);
			}
		}
		
		return masterList;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// T1 & T2 very large binary tree. T1 is much larger than T2
	// Check if T2 is subtree of T1
	//
	// Things to consider - duplicate element
	// One way to do is - Use stringbuilder and convert both trees to string
	// Use String lastIndexOf to check if it has the string
	// Alternative way is to use recursion
	
	boolean isSubTree(Node t1root, Node t2root)
	{
		if ((t1root == null) || (t2root == null))
		{
			return false;
		}
		
		if (t1root.data == t2root.data)
		{
			boolean result = isSubTreeUtil(t1root, t2root);
			{
				if (result == true)
				{
					return result;
				}
			}
			
		}
		
		return (isSubTree(t1root.left, t2root) || (isSubTree(t1root.right, t2root)));
	}

	boolean isSubTreeUtil(Node t1root, Node t2root)
	{
		if ((t1root == null) && (t2root == null))
		{
			return true;
		}
		
		if ((t1root == null) || (t2root == null))
		{
			return false;
		}
		
		if (t1root.data != t2root.data)
		{
			return false;
		}
		
		return (isSubTreeUtil(t1root.left, t2root.left) || isSubTreeUtil(t1root.right, t2root.right));
	}

	////////////////////////////////////////////////////////////////////////////////////////
	
	void printInOrder(Node curNode)
	{
		if (curNode == null)
		{
			return;
		}
		
		printInOrder(curNode.left);
		System.out.println(curNode.data);
		printInOrder(curNode.right);
	}

	void printBTree()
	{
		System.out.println("InOrder Binary Tree traversal: ");
	    printInOrder(root);
	}

	public static void main(String[] args)
	{
		BinaryTree bTree = new BinaryTree();
		
		bTree.addNode(0);
		bTree.addNode(1);
		bTree.addNode(2);
		bTree.addNode(3);
		bTree.addNode(4);
		bTree.addNode(5);
		bTree.addNode(6);
		bTree.addNode(7);
		bTree.addNode(8);
		bTree.addNode(9);

	    bTree.printBTree();
	    
	    ///////////////////////////////////////////////////////
	    // List of all nodes at depth D
	    List<List<Node>> listOfNodes = new ArrayList<>();
	    bTree.listOfNodesDFS(bTree.getRoot(), listOfNodes);
	    System.out.println("List of All nodes using DFS: ");
	    for(List<Node> nodeList : listOfNodes)
	    {
	    	for(Node n : nodeList)
	    	{
	    		System.out.printf("%d ", n.data);
	    	}
	    	System.out.println();
	    }
	    
	    listOfNodes.clear();
	    bTree.listOfNodesBFS(bTree.getRoot(), listOfNodes);
	    System.out.println("List of All nodes using BFS: ");
	    for(List<Node> nodeList : listOfNodes)
	    {
	    	for(Node n : nodeList)
	    	{
	    		System.out.printf("%d ", n.data);
	    	}
	    	System.out.println();
	    }
	    ///////////////////////////////////////////////////////////////
  	}
	
}
