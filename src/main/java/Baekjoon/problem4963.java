package Baekjoon;

import java.io.*;
import java.util.*;

public class problem4963 {

    static int W, H;
    static int[][] map;
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W==0 && H ==0) break;
            int cnt = 0;
            map = new int[H][W];
            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(map[i][j]>0){
                        cnt++;
                        countIsland(i,j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

    static void countIsland(int r, int c){
        map[r][c] =0;
        for(int i=0;i<8;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isRange(nr,nc) && map[nr][nc]>0)
                countIsland(nr, nc);
        }
    }
    static boolean isRange(int r, int c){
        return (r >=0 && r<H) && (c >=0 && c<W);
    }
}
