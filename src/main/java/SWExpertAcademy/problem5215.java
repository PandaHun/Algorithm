package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5215 {

	private static int[] grade;
	private static int[] kcal;
	private static int N, L;
	private static int answer;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			grade = new int[N];
			kcal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				grade[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			solve(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static void solve (int sum, int value, int index) {
		if (sum > L) {
			return;
		}
		if( index == N) {
			answer = Math.max(value, answer);
			return;
		}
		solve(sum + kcal[index], value + grade[index], index+1);
		solve(sum, value, index+1);
    }
}