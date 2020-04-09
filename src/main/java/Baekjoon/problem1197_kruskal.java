package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class problem1197_kruskal {

    static int V, E;
    static List<Edges> edges;
    static int[] parents;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edges(a, b, c));
        }
        Collections.sort(edges);
        parents = new int[V + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edges cur = edges.get(i);
            if (!sameRoot(cur.s, cur.d)) {
                answer += cur.c;
                union(cur.s, cur.d);
            }
        }
        System.out.println(answer);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            parents[b] = a;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static boolean sameRoot(int x, int y) {
        int a = find(x);
        int b = find(y);
        return a == b;
    }
}

class Edges implements Comparable<Edges> {

    int s;
    int d;
    int c;

    public Edges(int s, int d, int c) {
        this.s = s;
        this.d = d;
        this.c = c;
    }

    @Override
    public int compareTo(Edges o1) {
        return this.c - o1.c;
    }
}