package Baekjoon;

import java.io.*;
import java.util.*;

public class problem5719 {

    private static final int INF = 0x3f3f3f3f;

    private static int N, M, start, end;
    private static int[] dist;
    private static int[][] nodes;
    private static List<Integer>[] trace;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            dist = new int[N];
            nodes = new int[N][N];
            trace = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                dist[i] = INF;
                for (int j = 0; j < N; j++) {
                    nodes[i][j] = -1;
                }
                trace[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                nodes[s][e] = v;
            }

            dijkstra();
            remove();
            for(int i = 0 ; i < N; i++) {
                dist[i] = INF;
            }
            bw.write(dijkstra()+"\n");
        }
        bw.flush();
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int idx = current[0];
            int curDist = current[1];
            for (int next = 0; next < N; next++) {
                if (nodes[idx][next] != -1 && curDist + nodes[idx][next] <= dist[next]) {
                    dist[next] = curDist + nodes[idx][next];
                    pq.add(new int[]{next, dist[next]});
                    trace[next].add(idx);
                }
            }
        }
        return dist[end] >= INF ? -1 : dist[end];
    }

    private static void remove() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(end);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for(Integer pre : trace[current]) {
                if( nodes[pre][current] != -1 && dist[current] == dist[pre] + nodes[pre][current]) {
                    queue.add(pre);
                    nodes[pre][current] = -1;
                }
            }
        }
    }
}