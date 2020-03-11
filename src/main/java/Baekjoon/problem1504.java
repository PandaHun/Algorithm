package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1504 {

    static int N, E;
    static int[][] nodes;
    static boolean[] selected;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodes = new int[N + 1][N + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[s][e] = c;
            nodes[e][s] = c;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        long result = dijkstra(first, second);
        long resultSecond = dijkstra(second, first);
        if (result == -1 || resultSecond == -1) {
            System.out.println(-1);
        } else {
            if (result < resultSecond) {
                System.out.println(result);
            } else {
                System.out.println(resultSecond);
            }
        }
    }

    static long dijkstra(int m1, int m2) {
        long a1 = go(1, m1);
        long a2 = go(m1, m2);
        long a3 = go(m2, N);

        return (a1 == Integer.MAX_VALUE || a2 == Integer.MAX_VALUE || a3 == Integer.MAX_VALUE) ? -1 : a1 + a2 + a3;
    }

    static long go(int start, int end) {
        int[] dist = new int[N + 1];
        selected = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int from = 0;

            for (int k = 1; k < N + 1; k++) {
                if(!selected[k] && dist[k] < min) {
                    min = dist[k];
                    from = k;
                }
            }
            selected[from] = true;
            for(int to = 1; to < N+1; to++) {
               if(nodes[from][to] != 0) {
                   if(dist[to] > dist[from] + nodes[from][to]) {
                       dist[to] = dist[from] + nodes[from][to];
                   }
               }
            }
        }
        return dist[end];
    }
}
