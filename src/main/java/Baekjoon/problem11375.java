package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11375 {

    static int[] worker, job, visit;
    static int[][] adj;
    static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        worker = new int[N + 1];
        job = new int[M + 1];
        adj = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int t = Integer.parseInt(st.nextToken());
                adj[i][t] = 1;
            }
        }
        answer = 0;
        for (int i = 1; i <= N; i++) {
            if (worker[i] == 0) {
                visit = new int[N + 1];
                if (dfs(i)) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }

    static boolean dfs(int v) {
        if (visit[v] == 1) {
            return false;
        }
        visit[v] = 1;
        for (int b = 1; b < job.length; b++) {
            if (adj[v][b] == 1 && (job[b] == 0 || dfs(job[b]))) {
                worker[v] = b;
                job[b] = v;
                return true;
            }
        }
        return false;
    }
}
