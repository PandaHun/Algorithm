package Baekjoon;
/*
    @Content: 단지 번호 붙이기
 */

import java.io.*;
import java.util.*;

public class problem2667 {

    private static int N, answer, count;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int r=0; r<N;r++){
            String tmp = br.readLine();
            for(int c=0; c<N;c++){
                map[r][c] = tmp.charAt(c) -'0';
            }
        }

        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r = 0; r<N;r++){

            for(int c = 0; c<N;c++){
                if(map[r][c] == 1 && !visited[r][c]){
                    answer++;
                    count=0;
                    solve(r,c);

                    pq.add(count);
                }
            }
        }

        System.out.println(answer);
        while(!pq.isEmpty())
            System.out.println(pq.poll());

    }

    static void solve(int r, int c){
        visited[r][c] =true;
        count++;
        for(int i = 0; i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr <N && nc>=0 && nc<N){
                if(map[nr][nc] ==1 && !visited[nr][nc]) {
                    solve(nr, nc);
                }
            }
        }
    }
}
