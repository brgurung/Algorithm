
public class MinimalHeightBinaryTree {
	private class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data = data;
		}
	}

	Node binaryTreeUtil(int[] input, int leftIndex, int rightIndex)
	{
		if (leftIndex > rightIndex)
		{
			return null;
		}
		
		int midPoint = (leftIndex + rightIndex + 1) / 2;
		Node curNode = new Node(input[midPoint]);
		//System.out.println("CurNode: " + curNode.data);
		curNode.left = binaryTreeUtil(input, leftIndex, midPoint - 1);
		curNode.right = binaryTreeUtil(input, midPoint + 1, rightIndex);
		
		return curNode;
	}

	Node binaryTree(int[] input)
	{
		if ((input == null) || (input.length == 0))
		{
			return null;
		}
		
		return binaryTreeUtil(input, 0, input.length - 1);
	}


	void printTree(Node root)
	{
		if (root == null)
		{
			return;
		}
		
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}
	public static void main(String[] args)
	{
		MinimalHeightBinaryTree bTree = new MinimalHeightBinaryTree();
		
		int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		
		Node root = bTree.binaryTree(input);
		bTree.printTree(root);
	}
}
