package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 게리 맨더링2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem17779 {

    private static int N;
    private static int[][] map, district;
    private static int[] peoples;

    private static int answer = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 1; r <= N - 2; r++) {
            for (int c = 1; c <= N - 1; c++) {
                solve(r, c);
            }
        }

        System.out.println(answer);
    }

    static void solve( int r, int c ) {
        for (int d1 = 1; d1 < N + 1; d1++) {
            for (int d2 = 1; d2 < N + 1; d2++) {
                if (isRange(r, c, d1, d2)) {
                    gerry(r, c, d1, d2);
                }
            }
        }
    }

    static boolean isRange( int r, int c, int d1, int d2 ) {
        if (r + d1 > N || r + d2 > N) return false;
        if (c - d1 < 1 || c + d2 > N) return false;
        if (r + d1 + d2 > N) return false;
        if (c - d1 + d2 < 1 || c - d1 + d2 > N) return false;
        return true;
    }

    static void gerry( int r, int c, int d1, int d2 ) {
        district = new int[N + 1][N + 1];

        int t1 = 0, t2 = 0;
        boolean b1 = false, b2 = false;

        for (int y = r; y <= r + d1 + d2; y++) {

            for (int x = c - t1; x <= c + t2; x++) {
                district[y][x] = 5;
            }

            if (!b1) ++t1;
            else --t1;
            if (!b2) ++t2;
            else --t2;

            if (t1 == d1) b1 = true;
            if (t2 == d2) b2 = true;
        }

        for (int y = 1; y < N + 1; y++) {
            for (int x = 1; x < N + 1; x++) {
                if (district[y][x] == 5) continue;

                if (1 <= y && y < r + d1 && 1 <= x && x <= c) district[y][x] = 1;
                else if (1 <= y && y <= r + d2 && c < x && x <= N) district[y][x] = 2;
                else if (r + d1 <= y && y <= N && 1 <= x && x < c - d1 + d2) district[y][x] = 3;
                else if (r + d2 < y && y <= N && c - d1 + d2 <= x && x <= N) district[y][x] = 4;

            }
        }
        peoples = new int[6];

        for(int i = 1; i<N+1;i++){
            for(int j =1 ; j<N+1; j++){
                peoples[district[i][j]] += map[i][j];
            }
        }

        int max = -1, min = Integer.MAX_VALUE;
        for(int i = 1;i<6;i++){
            max = Math.max(max, peoples[i]);
            min = Math.min(min, peoples[i]);
        }

        answer = Math.min(answer, max-min);
    }
}
