import java.util.Random;

public class RandomBSTNode {

	private class Node
	{
		int data;
		int size;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data = data;
			size = 0;
		}
	}
	
	Node root;
	
	public void insertNodeUtil(int data, Node curNode)
	{
		if (curNode == null)
		{
			curNode = new Node(data);
		}
		else
		{
			if (data <= curNode.data)
			{
				insertNodeUtil(data, curNode.left);
			}
			else
			{
				insertNodeUtil(data, curNode.right);
			}
		}
		
		curNode.size += 1;
	}

	public void insertNode(int data)
	{
		insertNodeUtil(data, root);
	}


	public Node findNodeUtil(int data, Node curNode)
	{
		if (curNode == null)
		{
			return null;
		}
		
		if (data == curNode.data)
		{
			return curNode;
		}
		else if (data <= curNode.data)
		{
			return findNodeUtil(data, curNode.left);
		}
		else
		{
			return findNodeUtil(data, curNode.right);
		}
	}

	public Node getNthNode(int index, Node curNode)
	{
		int leftSize = (root.left == null) ? 0 : root.left.size;
		
		if (index < leftSize)
		{
			return getNthNode(index, curNode.left);
		}
		else if (index == leftSize)
		{
			return curNode;
		}
		else
		{
			return getNthNode(index - leftSize + 1, curNode.right);
		}
	}

	public Node getRandomNode()
	{
		if (root == null)
		{
			return null;
		}

		Random random = new Random();
		
		int index = random.nextInt(root.size);
		
		return getNthNode(index, root);
	}

	public Node findNode(int data)
	{
		return findNodeUtil(data, root);
	}

}
