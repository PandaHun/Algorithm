package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 보물섬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2589 {

    private static int N, M;
    private static int answer = Integer.MIN_VALUE;
    private static char LAND = 'L';
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int[][] map, distance;
    private static boolean[][] isVisited;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (temp.charAt(j) == LAND) {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    bfs(i, j);
            }
        }

        System.out.println(answer);
    }


    private static void bfs( int r, int c ) {
        distance = new int[N][M];
        isVisited = new boolean[N][M];
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(r,c));
        isVisited[r][c] = true;

        while(!queue.isEmpty()) {
            point current = queue.poll();
            int cr = current.r;
            int cc = current.c;
            for(int k = 0; k < 4; k ++ ){
                int nr = cr + dr[k];
                int nc = cc + dc[k];

                if (nr<0 || nc < 0 || nr >=N || nc >=M) continue;
                if (map[nr][nc] ==0 || isVisited[nr][nc]) continue;

                queue.offer(new point(nr,nc));
                isVisited[nr][nc] = true;
                distance[nr][nc] = distance[cr][cc] +1;
                answer = Math.max(answer, distance[nr][nc]);
            }
        }
    }
}

class point {
    int r;
    int c;

    public point(int r,int c) {
        this.r = r;
        this.c = c;
    }
}
