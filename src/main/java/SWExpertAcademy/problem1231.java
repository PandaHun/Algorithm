package SWEA_Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1231 {

	private static int N;
	private static char[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				tree[index] = st.nextToken().charAt(0);
			}
			inOrder(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void inOrder(int V) {
		if(V <= N ) {
			inOrder(V*2);
			sb.append(tree[V]);
			inOrder(V*2 +1);
		}
	}
}
