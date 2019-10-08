package Baekjoon;
/*
    @Contents: 유기농 배추
 */

import java.io.*;
import java.util.*;

public class problem1012 {

    private static int T, N, M;
    private static boolean[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            for(int i = 0; i<K;i++){
                st = new StringTokenizer(br.readLine(), " ");
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = true;
            }
            int answer =0;
            for(int r=0;r<N;r++){

                for(int c=0;c<M;c++){
                    if(map[r][c]){
                        solve(r,c);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void solve(int r, int c) {
        map[r][c] = false;
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(r,c));

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >=N || nc >= M || !map[nr][nc]){
                continue;
            }
            queue.add(new Dot(nr,nc));
            solve(nr,nc);

        }
    }
}
class Dot{
    int r;
    int c;
    public Dot(int r, int c){
        this.r = r;
        this.c = c;
    }

}
