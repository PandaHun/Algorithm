package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem15649 {

	private static int N, M;
	private static boolean[] visited;
	private static int[] answer;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		visited = new boolean[N + 1];

		solve(0);
		System.out.println(sb);
	}

	private static void solve(int depth) {

		if (depth == M) {
			for (int a : answer) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i < N + 1; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			answer[depth] = i;
			solve(depth + 1);
			visited[i] = false;
		}

	}
}
