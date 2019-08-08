package Baekjoon;

import java.util.*;
import java.io.*;

public class problem14503 {

    static int N, M, R, C, D;
    //D : 0 N, 1 E, 2 S, 3 W
    static int[][] map;
    static int answer = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int turn = 0;
    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine() ," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map =new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }
    static void solve(){

        while(true){

            if(map[R][C] == 0){
                answer++;
                map[R][C] = 2;
            }

            boolean ret = false;

            for(int i=0;i<4;i++){

                int nextDirection = (D+3)%4;
                int nextY = R + dy[nextDirection];
                int nextX = C + dx[nextDirection];

                if(map[nextY][nextX] == 0){
                    R = nextY;
                    C = nextX;
                    D = nextDirection;

                    ret = true;
                    break;
                }
                else {
                    D = nextDirection;
                }
            }

            if(!ret){
                if(map[R - dy[D]][C - dx[D]] == 1 ){
                    System.out.println(answer);
                    break;
                }

                else{
                    R = R - dy[D];
                    C = C - dx[D];
                }
            }

        }
    }

}
