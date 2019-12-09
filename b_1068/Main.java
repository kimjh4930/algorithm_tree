package b_1068;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static Node[] nodes = new Node[51];
	static int count = 0;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		int num;
		Node root = null;
		
		for(int i=0; i<N; i++) {
			num = scan.nextInt();
			
			if(num == -1) {
				root = new Node(i);
				nodes[i] = root;
			}else {
				nodes[i] = new Node(i);
				nodes[i].parent = nodes[num];
				nodes[num].children.add(nodes[i]);
			}
		}
		
		int remove = scan.nextInt();
		
		if(nodes[remove].parent != null) {
			nodes[remove].parent.children.remove(nodes[remove]);
		}
		nodes[remove].children.clear();
		nodes[remove] = null;
		
		countLeaf(root);
		
		System.out.println(count);
		
		scan.close();
	}
	
	static void countLeaf (Node node) {
		if(node.children.size() == 0) {
			System.out.println("val : " + node.val);
			count++;
		}else {
			for(int i=0; i<node.children.size(); i++) {
				countLeaf(node.children.get(i));
			}
		}
	}

}

class Node {
	int val;
	Node parent = null;
	List<Node> children = new ArrayList<>();
	
	public Node (int val) {
		this.val = val;
	}
}
