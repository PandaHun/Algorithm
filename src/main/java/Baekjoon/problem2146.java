package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 다리 만들기
 */

import java.io.*;
import java.util.*;

public class problem2146 {

    private static int N;
    private static int[][] map, nmap;
    private static boolean[][] visited;
    private static int[] dr = {-1,1,0,0};
    private static int[] dc = {0,0,-1,1};
    private static int answer = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        nmap = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 1;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1) {
                    cnt++;
                    makeIsland(i, j, cnt);
                }
            }
        }
        set();
        for(int i = 0 ; i <N;i++){
            for(int j = 0 ; j<N;j++){
                if(map[i][j]!=0) {
                    BFS(i, j);
                    set();
                }
            }
        }

        System.out.println(answer);
    }
    static void BFS(int r, int c){
        Queue<Island> islands = new LinkedList<>();
        islands.add(new Island(r,c,0));

        while(!islands.isEmpty()){
            Island now = islands.poll();

            for(int k = 0 ; k < 4; k ++){
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                int nlength = now.length+1;

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if(nmap[nr][nc] == nmap[r][c]) continue;

                if(nmap[nr][nc] == -1) continue;

                if(nmap[nr][nc] !=0){
                    answer = answer < now.length ? answer : nlength-1;
                    return;
                }

                nmap[nr][nc] =  -1;
                islands.add(new Island(nr, nc, nlength));
            }
        }

    }


    static void set(){
        for(int i = 0 ; i < N;i++){
            nmap[i] = Arrays.copyOf(map[i], N);
        }
    }

    static void makeIsland(int r, int c, int label){
        for(int k = 0 ; k < 4; k++){
            int nr = r +dr[k];
            int nc = c +dc[k];

            if(nr < 0 || nc < 0 || nr >=N || nc>=N) continue;

            if(map[nr][nc] == label || map[nr][nc] == 0) continue;

            map[nr][nc] = label;
            makeIsland(nr, nc, label);
        }
    }
}
class Island{
    int r;
    int c;
    int length;
    public Island(int r, int c, int length){
        this.r = r;
        this.c = c;
        this.length = length;
    }
}
