package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class problem1861 {
    static int N;
    static int[][] INPUT;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer;

    public static void main( String[] args ) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc =1;tc<=T;tc++){
            int max = -1;
            N = Integer.parseInt(br.readLine());
            INPUT = new int[N][N];
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0;k<N;k++){
                    INPUT[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[] count = new int [100000];
            for(int j=0; j<N*N;j++){
                int y = j/N;
                int x = j%N;
                answer = 1;
                dfs(y,x);
                count[INPUT[y][x]] = answer;
            }
            int min = Integer.MAX_VALUE;
            for(int i =0;i<N*N;i++){
                if(max <count[i]){
                    max = count[i];
                    min = i;
                }
            }
            System.out.println("#" +tc + " " + min + " " + max);
        }
    }

    public static void dfs(int y, int x){

        int now = INPUT[y][x];
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx <N && ny < N && INPUT[ny][nx] - now == 1){
                answer ++;
                dfs(ny,nx);
            }
        }
    }
}
