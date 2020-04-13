package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2887 {

    static int N;
    static int[] parents;
    static int[][] nodes;
    static PriorityQueue<Planet> pq;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nodes = new int[N][4];
        parents = new int[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());
            nodes[i][2] = Integer.parseInt(st.nextToken());
            nodes[i][3] = i + 1;
        }
        pq = new PriorityQueue<>();
        Arrays.sort(nodes, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < N; i++) {
            pq.add(new Planet(nodes[i - 1][3], nodes[i][3], Math.abs(nodes[i - 1][0] - nodes[i][0])));
        }
        Arrays.sort(nodes, (o1, o2) -> o1[1] - o2[1]);
        for (int i = 1; i < N; i++) {
            pq.add(new Planet(nodes[i - 1][3], nodes[i][3], Math.abs(nodes[i - 1][1] - nodes[i][1])));
        }
        Arrays.sort(nodes, (o1, o2) -> o1[2] - o2[2]);
        for (int i = 1; i < N; i++) {
            pq.add(new Planet(nodes[i - 1][3], nodes[i][3], Math.abs(nodes[i - 1][2] - nodes[i][2])));
        }
        int cnt = 0;
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        while (cnt < N && !pq.isEmpty()) {
            Planet now = pq.poll();
            if (find(now.s) != find(now.e)) {
                cnt++;
                answer += now.cost;
                union(now.s, now.e);
            }
        }
        System.out.println(answer);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            parents[b] = a;
        }
    }
}

class Planet implements Comparable<Planet> {

    int s;
    int e;
    int cost;

    public Planet(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Planet o) {
        return this.cost - o.cost;
    }
}