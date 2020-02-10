package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem14500 {

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = Integer.MIN_VALUE;
    private static int[] dr = { 1, 0, -1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                tetromino(r, c, 1, map[r][c]);
                cross(r,c);
            }
        }
        System.out.println(answer);
    }


    static int[][][] value = {
            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{0,0}, {0,1}, {0,2}, {-1,1}},
            {{0,0},{1,0},{1,1},{2,0}},
            {{0,0},{1,0}, {2,0}, {1,-1}}
    };

    static void cross(int r, int c) {

        for(int i = 0 ; i < 4; i++) {
            int sum = 0;
            for(int j = 0 ; j < 4; j ++) {
                int nr = r + value[i][j][0];
                int nc = c + value[i][j][1];
                if( nr < 0 || nc < 0 || nr >=N || nc >=M ) {
                    continue;
                }
                sum += map[nr][nc];
            }
            answer = Math.max(answer, sum);
        }
    }

    static void tetromino(int r, int c, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        if (depth > 4) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if( nr < 0 || nc < 0 || nr >=N || nc >=M ) {
                continue;
            }
            if(visited[nr][nc]) {
                continue;
            }
            tetromino(nr,nc,depth+1, sum + map[nr][nc]);
        }
        visited[r][c] = false;
    }
}
