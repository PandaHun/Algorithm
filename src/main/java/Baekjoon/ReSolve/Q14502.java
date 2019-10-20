package Baekjoon.ReSolve;
/*
 *  @Author: Pandahun
 *  @Content: 연구소
 *  @Try: 2nd
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14502 {

    private static int N, M;
    private static int[][] map, nmap;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static List<Virus> virusList;
    private static int answer = Integer.MIN_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nmap = new int[N][M];
        map = new int[N][M];
        virusList = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    virusList.add(new Virus(r, c));
                }
            }
        }

        solve(0, 0);
        System.out.println(answer);
    }

    static void solve( int depth, int index ) {

        if (depth == 3) {
            for(int i = 0 ; i<N;i++){
                for(int j = 0 ; j<M;j++)
                    nmap[i][j] = map[i][j];
            }

            for (Virus now : virusList)
                spread(now.r, now.c);
            int tmp = getSafeArea();
            answer = answer > tmp ? answer : tmp;
            return;
        }

        for(int i = index; i < N*M;i++){
            int r = i / M;
            int c = i % M;
            if(map[r][c] ==0){
                map[r][c] = 1;
                solve(depth+1, index+1);
                map[r][c] = 0;
            }
        }
    }

    static void spread( int r, int c ) {

        for(int i = 0; i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >=N || nc >=M ) continue;

            if(nmap[nr][nc]!=0) continue;

            nmap[nr][nc] = 2;
            spread(nr, nc);
        }
    }

    static int getSafeArea(){
        int cnt = 0;

        for(int i = 0 ; i<N;i++){
            for(int j = 0; j < M; j++)
                if(nmap[i][j] == 0)
                    cnt++;
        }

        return cnt;
    }
}

class Virus {
    int r;
    int c;

    public Virus( int r, int c ) {
        this.r = r;
        this.c = c;
    }
}