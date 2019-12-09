package b_1991;

import java.util.Scanner;

public class Main {
	
	static Node[] nodes = new Node[26];
	static int[] count = new int[26];
	static int N;
	
	static StringBuffer result;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<N; i++) {
			char[] inputs = scan.nextLine().replace(" ", "").toCharArray();
			
			Node node = new Node(inputs[0]);
			count[inputs[0] - 'A']++;
			
			if(inputs[1] != '.') {
				node.left = new Node(inputs[1]);
				count[inputs[1] - 'A']++;
			}
			
			if(inputs[2] != '.') {
				node.right = new Node(inputs[2]);
				count[inputs[2] - 'A']++;
			}
			
			nodes[node.val -'A'] = node;
		}
		
		Node root = null;
		
		for(int i=0; i<26; i++) {
			if(count[i] == 1) {
				root = nodes[i];
				break;
			}
		}
		
		result = new StringBuffer();
		
		printPreOrder(root);
		result.append("\n");
		printInOrder(root);
		result.append("\n");
		printPostOrder(root);
		result.append("\n");
		
		System.out.println(result.toString());
		
		scan.close();
	}
	
	static void printPreOrder (Node root) {
		result.append(root.val);
		if(root.left != null)	printPreOrder(nodes[root.left.val - 'A']);
		if(root.right != null)	printPreOrder(nodes[root.right.val - 'A']);
	}
	static void printInOrder (Node root) {
		if(root.left != null) 	printInOrder(nodes[root.left.val - 'A']);
		result.append(root.val);
		if(root.right != null) 	printInOrder(nodes[root.right.val - 'A']);
	}
	static void printPostOrder (Node root) {
		if(root.left != null)	printPostOrder(nodes[root.left.val - 'A']);
		if(root.right != null) 	printPostOrder(nodes[root.right.val - 'A']);
		result.append(root.val);
	}

}

class Node {
	char val;
	Node left, right;
	
	public Node (char val) {
		this.val = val;
		left = right = null;
	}
}
