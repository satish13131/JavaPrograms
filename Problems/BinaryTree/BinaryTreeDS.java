package Problems.BinaryTree;

import java.util.Scanner;

public class BinaryTreeDS {
	
	static Node root = null;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		String input = null;
		int optionNo = -1;
		int parent = -1;
		int value = -1;
		int orientation = -1;
		
		Node tempNode = null;
		while (isContinue) {
			
			System.out.println("Select the option");
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Exit");
			System.out.println("4. InOrderTraversal");
			System.out.println("5. PreOrderTraversal");
			System.out.println("6. PostOrderTraversal");
			input = scanner.nextLine();
			optionNo = Integer.parseInt(input);
			switch (optionNo) {
			case 1:

				System.out.println("Enter the node");
				input = scanner.nextLine();
				value = Integer.parseInt(input);
				System.out.println("Enter the parent");
				input = scanner.nextLine();
				parent = Integer.parseInt(input);
				System.out.println("Enter the orientation 1. Left, 2.Right");
				input = scanner.nextLine();
				orientation = Integer.parseInt(input);
				insertNode(root, value, parent, orientation);
				break;
				
			case 2:	
				
				System.out.println("Enter the node");
				input = scanner.nextLine();
				value = Integer.parseInt(input);
				tempNode = findNode(root, value);
				if (tempNode == null)
				{
					System.out.println("Node not found");
				}
				else {
					System.out.println("Node found");
				}				
				break;
				
			case 3:
				isContinue = false;
				break;
				
			case 4:
				traverseInOrder(root);
				System.out.println("");
				break;
				
			case 5:
				traversePreOrder(root);
				System.out.println("");
				break;
				
			case 6:
				traversePostOrder(root);
				System.out.println("");
				break;
				
			default :
				isContinue = false;
				break;
			}
		}
		
		scanner.close();
	}
	
	private static void insertNode(Node root, int value, int parent, int orientation)
	{
		if (root == null)
		{
			root = new Node();
			BinaryTreeDS.root = root;
			root.value = value;
		}
		else
		{
			Node parentNode = findNode(root, parent);
			if (parentNode != null)
			{
				if (orientation == 1) {
					parentNode.left = new Node();
					parentNode.left.value = value;
				}
				else if (orientation == 2) {
					parentNode.right = new Node();
					parentNode.right.value = value;
				}
			}
		}
	}
	
	private static Node findNode(Node root, int value)
	{
		Node result = null;
		if (root == null)
		{
			return null;
		}
		if (root.value == value)
		{
			result = root;
		}
		else {
			result = findNode(root.left, value);
			if (result == null)
			{
				result = findNode(root.right, value);
			}
		}
		return result;
	}
	
	private static void traverseInOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		traverseInOrder(root.left);
		System.out.print(root.value + " ");
		traverseInOrder(root.right);
		
	}
	
	private static void traversePreOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		System.out.print(root.value + " ");
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}
	
	private static void traversePostOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		traversePostOrder(root.left);
		traversePostOrder(root.right);
		System.out.print(root.value + " ");
	}
	
	private static class Node {
		int value;
		Node left = null;
		Node right = null;
	}

}
