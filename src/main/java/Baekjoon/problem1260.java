package Baekjoon;

/*
 *  @Author: Pandahun
 *  @Content: DFS와 BFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1260 {

    private static int N, M, V;
    private static int[][] node;
    private static boolean[] visited;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M ; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            node[start][end] = 1;
            node[end][start] = 1;
        }
        dfs(V);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V);

    }
    static void dfs(int start){
        visited[start] = true;
        System.out.print(start+" ");

        for(int i = 1; i<=N;i++){
            if(node[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            System.out.print(now +" ");
            for(int i = 1; i<=N;i++){
                if(node[now][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
