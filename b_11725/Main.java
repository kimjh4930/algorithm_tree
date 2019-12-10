package b_11725;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Integer>[] nodeList = new ArrayList[100001];
	static int[] parents = new int[100001];
	static boolean[] visited = new boolean[100001];
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i=1; i<=N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		int n, m;
		
		for(int i=1; i<N; i++) {
			n = scan.nextInt();
			m = scan.nextInt();
			
			nodeList[n].add(m);
			nodeList[m].add(n);
		}
		
		visited[1] = true;
		findParent(1);
		
		StringBuffer str = new StringBuffer();
		
		for(int i=2; i<=N; i++) {
			str.append(parents[i]).append("\n");
		}
		
		System.out.println(str.toString());
			
		scan.close();
	}
	
	static void findParent (int node) {
		for(Integer child : nodeList[node]) {
			if(visited[child] == false) {
				visited[child] = true;
				parents[child] = node;
				findParent(child);				
			}
		}
	}

}
