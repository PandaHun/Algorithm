package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem11779 {

    static int N, M, S, E;
    static ArrayList<Point>[] map;
    static int[] dist, routes;
    static Stack<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        dist = new int[N + 1];
        routes = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[a].add(new Point(b, v));
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dijkstra();
        findRoutes();
        bw.write(dist[E] +"\n");
        bw.write(answer.size() +"\n");
        while (!answer.isEmpty()) {
            bw.write(answer.pop() + " ");
        }
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(S, 0));
        dist[S] = 0;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.e == E) {
                return;
            }
            for (Point next : map[now.e]) {
                if (dist[next.e] > dist[now.e] + next.v) {
                    dist[next.e] = dist[now.e] + next.v;
                    pq.add(new Point(next.e, dist[next.e]));
                    routes[next.e] = now.e;
                }
            }
        }
    }

    static void findRoutes() {
        answer = new Stack<>();
        int t = E;
        while (t!=S) {
            answer.push(t);
            t = routes[t];
        }
        answer.push(t);
    }

    static class Point implements Comparable<Point> {
        int e;
        int v;

        public Point(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Point o) {
            return this.v - o.v;
        }
    }
}
