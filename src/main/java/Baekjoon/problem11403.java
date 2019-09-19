package Baekjoon;

import java.io.*;
import java.util.*;

public class problem11403 {
    static int n;
    static int[][] graph;
    static Queue<Integer> q = new LinkedList<>();
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(graph[i][j] == 1) {
                    q.add(j);
                }
            }
            while(!q.isEmpty()){
                int tmp = q.poll();
                bfs(i,tmp);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(graph[i][j] +" ");
            }
            System.out.println();
        }
    }
    static void bfs(int idx, int tmp){
        graph[idx][tmp] = 1;
        for(int i=0;i<n;i++){
            if(graph[tmp][i] ==1 && graph[idx][i]!=1){
                q.add(i);
            }
        }
    }
}
