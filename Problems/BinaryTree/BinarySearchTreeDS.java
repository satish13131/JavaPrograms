package Problems.BinaryTree;

import java.util.Scanner;

public class BinarySearchTreeDS {
	
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
				insertNode(root, value);
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
	
	private static void insertNode(Node root, int value)
	{
		if (root == null)
		{
			root = new Node();
			BinarySearchTreeDS.root = root;
			root.value = value;
		}
		else
		{
			if (root.value != value) {
				if (root.value > value) {
					if (root.left == null)
					{
						root.left = new Node();
						root.left.value = value;
					}
					else
					{
						insertNode(root.left, value);
					}
				}
				else
				{
					if (root.right == null)
					{
						root.right = new Node();
						root.right.value = value;
					}
					else
					{
						insertNode(root.right, value);
					}
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
		else if (root.value > value){
			result = findNode(root.left, value);
		}
		else if (root.value < value){
			result = findNode(root.right, value);
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

//input samples
//2,1,5,4