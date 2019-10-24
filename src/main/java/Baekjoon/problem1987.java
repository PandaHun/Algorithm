package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 알파벳
 */

import java.io.*;
import java.util.*;

public class problem1987 {

    private static int[][] map;
    private static int[] dr = {-1,1,0,0};
    private static int[] dc = {0,0,1,-1};
    private static int answer, cnt, R, C;
    private static boolean[] visit = new boolean[26];

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        answer = 0;
        cnt = 0;
        for(int i = 0 ; i <R ; i++){
            String temp = br.readLine();
            for(int j = 0 ; j < C ;j++){
                map[i][j] = temp.charAt(j)-'A';
            }
        }

        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int r, int c) {

        cnt++;
        if(answer < cnt)
            answer = cnt;
        visit[map[r][c]] = true;

        for(int k = 0 ;  k <4 ; k++){
            int nr = r +dr[k];
            int nc = c +dc[k];

            if(nr < 0 || nc < 0 || nr >=R || nc >=C) continue;

            if(!visit[map[nr][nc]])
                dfs(nr,nc);
        }

        cnt--;
        visit[map[r][c]] = false;

    }
}
