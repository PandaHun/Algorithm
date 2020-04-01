package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {

    public static void main(String[] args) {
        int[][] edge = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        System.out.println(solution(6, edge));
    }

    static int[] distance;
    static boolean[] visited;
    static ArrayList<Integer>[] nodes;

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        nodes = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[i] = 50001;
            nodes[i] = new ArrayList<Integer>();
        }
        for (int[] i : edge) {
            int a = i[0];
            int b = i[1];
            nodes[a].add(b);
            nodes[b].add(a);
        }
//        for (int i = 2; i < n + 1; i++) {
//            visited = new boolean[n+1];
//            dfs(1,i,0);
//        }
        bfs();
        for(int i : distance ) {
            System.out.print(i +" ");
        }
        System.out.println();
        int max = -1;
        for (int i = 2; i < n + 1; i++) {
            if (max < distance[i]) {
                max = distance[i];
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (distance[i] == max) {
                answer++;
            }
        }
        return answer;
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        distance[1] = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            int size = nodes[n].size();
            for(int i = 0 ; i < size; i++) {
                int v = nodes[n].get(i);
                if( !visited[v]) {
                    visited[v] = true;
                    distance[v] = Math.min(distance[n] + 1, distance[v]);
                    queue.add(v);
                }
            }
        }
    }

    static void dfs(int v, int d, int dis) {
        if (v == d) {
            distance[d] = Math.min(dis, distance[d]);
        }
        for (int i = 0; i < nodes[v].size(); i++) {
            int n = nodes[v].get(i);
            if (!visited[n]) {
                visited[n] = true;
                dfs(n, d, dis + 1);
                visited[n] = false;
            }
        }
    }
}
