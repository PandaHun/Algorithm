package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1916 {

    static int N, M, S, E;
    static ArrayList<Info>[] map;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Info(b, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(dist[E]);
    }

    static void dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(S, 0));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Info t = pq.poll();
            if (dist[t.d] < t.w) {
                continue;
            }
            for (int i = 0; i < map[t.d].size(); i++) {
                Info next = map[t.d].get(i);
                if (dist[next.d] > dist[t.d] + map[t.d].get(i).w) {
                    dist[next.d] = dist[t.d] + map[t.d].get(i).w;
                    pq.add(new Info(next.d, dist[next.d]));
                }
            }
        }
    }
}

class Info implements Comparable<Info> {

    int d;
    int w;

    public Info(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Info o) {
        return this.w - o.w;
    }
}