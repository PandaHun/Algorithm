package Baekjoon;

import java.io.*;
import java.util.*;

public class problem1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, X, ans;
    static ArrayList<int[]>[] order, reverse;
    static int[] w ,reversed;
    static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        order = new ArrayList[N + 1];
        reverse = new ArrayList[N + 1];
        w = new int[N + 1];
        reversed = new int[N + 1];
        Arrays.fill(w, 100_000_000);
        Arrays.fill(reversed, 100_000_000);
        for (int i = 1; i <= N; i++) {
            order[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        int a, b, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            order[a].add(new int[]{b, c});
            reverse[b].add(new int[]{a, c});
        }
        ans = -1;
        visited = new boolean[N+1];
        bfs(order, w);
        visited = new boolean[N+1];
        bfs(reverse, reversed);

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            ans = Math.max(ans, w[i] + reversed[i]);
        }

        bw.write(ans + " \n");
        bw.flush();
        br.close();
        bw.close();

    }

    private static void bfs(ArrayList<int[]>[] map, int[] w) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{X, 0});
        w[X] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if ( visited[now[0]]) {
                continue;
            }
            for (int[] next : map[now[0]]) {
                if (w[next[0]] > now[1] + next[1]) {
                    w[next[0]] = now[1] + next[1];
                    q.add(new int[]{next[0], w[next[0]]});
                }
            }
        }
    }
}