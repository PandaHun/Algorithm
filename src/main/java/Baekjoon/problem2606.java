package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 바이러스
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2606 {

    private static int N, M;
    private static int[][] node;
    private static boolean[] visited;
    private static int answer;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;

        N = Integer.parseInt(br.readLine());

        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i< M ;i ++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
        }

        solve(1);
        System.out.println(answer);
    }

    static void solve(int start){
        visited[start] = true;

        for(int i = 1; i<N+1;i++){
            if(node[start][i] == 1 && !visited[i]){
                answer++;
                solve(i);
            }
        }
    }
}
