package Baekjoon;

import java.io.*;
import java.util.*;

public class problem2178 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int N,M;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " '");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int r = 0; r<N;r++){
            String temp = br.readLine();
            for(int c=0;c<M;c++){
                map[r][c] = temp.charAt(c) - '0';
            }
        }
        visited[0][0] = true;
        solve(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    static void solve(int r, int c){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));

        while(!queue.isEmpty()){

            Point now = queue.poll();
            for(int i=0; i<4;i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(nr<0 || nc < 0 || nr >=N || nc >=M || visited[nr][nc] || map[nr][nc] ==0)
                    continue;

                queue.add(new Point(nr, nc));
                map[nr][nc] = map[now.r][now.c] +1;
                visited[nr][nc] = true;
            }
        }
    }
}

class Point{
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
