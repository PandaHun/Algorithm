package Baekjoon;

import java.io.*;
import java.util.*;

public class problem7576 {

    private static int N,M;
    private static int[][] box;
    private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {-1, 1, 0, 0};
    private static Queue<Position> apples;
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        apples = new LinkedList<>();
        for(int i = 0 ; i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<M;j++){
                int tmp = Integer.parseInt(st.nextToken());
                box[i][j] = tmp;
                if(tmp == 1)
                    apples.offer(new Position(i, j, 0));
            }
        }

        solve();
    }

    static void solve(){
        int day = 0;
        while(!apples.isEmpty()){
            Position now = apples.poll();
            day = now.day;
            for(int i = 0; i<4; i++){
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                if( nr >=0&& nr < N && nc>=0 && nc<M){
                    if(box[nr][nc]==0){
                        box[nr][nc] = 1;
                        apples.offer(new Position(nr,nc, now.day+1));
                    }
                }
            }
        }

        if(check())
            System.out.println(day);
        else
            System.out.println(-1);
    }

    static boolean check(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (box[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}

class Position{
    int r;
    int c;
    int day;
    public Position(int r, int c, int day){
        this.r = r;
        this.c = c;
        this.day = day;
    }
}