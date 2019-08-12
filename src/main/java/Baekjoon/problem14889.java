package Baekjoon;

import java.util.*;
import java.io.*;

public class problem14889 {
    static int n;
    static int[][] input;
    static boolean[] visited;
    static int answer;

    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        input = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=n;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        solve(1, 0);

        System.out.println(answer);
    }

    static void solve(int start, int depth){

        if(depth == n/2){
            int temp = getAnswer();
            answer = answer > temp ? temp : answer;
            return;
        }
        for(int i=start; i <n+1; i++){
            if(!visited[i]){
                visited[i] =true;
                solve(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static int getAnswer(){
        int startSum = 0;
        int linkSum = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if( visited[i] && visited[j])
                    startSum += input[i][j];

                if(!visited[i] && !visited[j])
                    linkSum += input[i][j];
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
