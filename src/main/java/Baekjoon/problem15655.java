package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem15655 {

    private static int N;
    private static int M;
    private static int[] input;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        visited = new boolean[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        solve(0, 0);
        System.out.println(sb);
    }

    private static void solve(int depth, int index) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                solve(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
