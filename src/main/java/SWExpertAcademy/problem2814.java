package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem2814 {

    private static int N, M, answer;
    private static int[][] adj;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adj = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int k = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                adj[k][j] = 1;
                adj[j][k] = 1;
            }

            answer = 0;
            for (int i = 1; i <= N; i++) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    private static void dfs(int v, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 1; i <= N; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
