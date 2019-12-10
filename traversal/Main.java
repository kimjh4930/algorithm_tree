package traversal;

import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		String[] input;
		
		for(int test_case=0; test_case<T; ++test_case) {
			N = scan.nextInt();
			scan.nextLine();
			
			input = scan.nextLine().split(" ");
			int[] pre = new int[N];
			for(int i=0; i<N; i++) {
				pre[i] = Integer.parseInt(input[i]);
			}
			
			input = scan.nextLine().split(" ");
			int[] in = new int[N];
			for(int i=0; i<N; i++) {
				in[i] = Integer.parseInt(input[i]);
			}
			
			printPreOrder(pre, in, N);
			System.out.println();
			
		}
		
		scan.close();
	}
	
	static void printPreOrder(int[] pre, int[] in, int size) {
		
		if(size == 0) {
			return;
		}
		
		int root = pre[0];
		int idx = 0;
		for(int i=0; i<size; i++) {
			if(in[i] == root) {
				idx = i;
				break;
			}
		}
		
		int L = idx;
		int R = size - (idx+1);
		
		printPreOrder(subTree(pre, 1, idx), subTree(in, 0, idx-1), L);
		printPreOrder(subTree(pre, idx+1, size-1), subTree(in, idx+1, size-1), R);
		System.out.print(root + " ");
		
	}
	
	static int[] subTree (int[] arr, int start, int end) {
		int size = end - start + 1;
		int[] sub = new int[size];
		for(int i=0; i<size; i++) {
			sub[i] = arr[start+i];
		}
		
		return sub;
	}
	
//	static void printPreOrder(int start, int end, int size) {
//		
//		if(size - start == 0) {
//			return;
//		}
//		
//		int idx = 0;
//		for(idx=start; idx<=end; idx++) {
//			if(pre[start] == in[idx]) {
//				break;
//			}
//		}
//		
//		int leftSize = idx;
//		int rightSize = end-idx;
//		
//		System.out.println(leftSize + ", " + rightSize);
//		
//		//left
//		printPreOrder(start+1, idx, leftSize);
//		//right;
//		printPreOrder(idx+1, end, rightSize);
//		//print
//		System.out.println(pre[start]);
//	}

}
