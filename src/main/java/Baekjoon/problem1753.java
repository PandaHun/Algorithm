package Baekjoon;

import java.io.*;
import java.util.*;

public class problem1753 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Vertex>[] edges = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int now = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[now].add(new Vertex(end, value));
        }

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.add(new Vertex(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Vertex now = q.poll();
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;
            for (Vertex current : edges[now.end]) {
                if (dist[current.end] > dist[now.end] + current.value) {
                    dist[current.end] = dist[now.end] + current.value;
                    q.add(new Vertex(current.end, dist[current.end]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }
        bw.flush();
    }
}

class Vertex implements Comparable<Vertex>{

    int end;
    int value;

    public Vertex(int end, int value) {
        this.end = end;
        this.value = value;
    }

    public int compareTo(Vertex v1 ) {
        return this.value - v1.value;
    }
}
