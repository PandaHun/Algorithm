package Baekjoon;

import java.io.*;
import java.util.*;

public class problem5719 {

    static final int INF = 100000000;

    static int N, M, S, E;
    static int[] dist;
    static int[][] map;

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
            map = new int[N][N];
            dist = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                dist[i] = INF;
                for (int j = 0; j < N; j++) {
                    map[i][j] = INF;
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                map[s][d] = v;
            }

            dijkstra();
            remove();
            for(int i = 0 ; i < N; i++) {
                dist[i] = INF;
            }
            dijkstra();

            bw.write(dist[E] == INF ? "-1\n" : dist[E] + "\n");
        }
        bw.flush();
    }

    static void remove() {
        Queue<Integer> q = new LinkedList<>();
        q.add(E);

        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0 ; i < N; i++) {
                if( dist[now] == dist[i] + map[i][now]) {
                    map[i][now] = INF;
                    q.add(i);
                }
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(S, dist[S] = 0));

        while (!pq.isEmpty()) {
            Data now = pq.poll();
            if (dist[now.node] < now.cost) {
                continue;
            }
            if (now.node == E) {
                break;
            }
            for (int i = 0; i < N; i++) {
                if (map[now.node][i] != INF && dist[i] > now.cost + map[now.node][i]) {
                    dist[i] = now.cost + map[now.node][i];
                    pq.add(new Data(i, now.cost + map[now.node][i]));
                }
            }
        }
    }
}

class Data implements Comparable<Data> {

    int node;
    int cost;

    public Data(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Data o) {
        return this.cost - o.cost;
    }
}