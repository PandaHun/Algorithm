package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 벽 부수고 이동하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2206 {

    private static int N, M;
    private static int[][] map, count;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        count = new int[N+1][M+1];
        for(int i = 1; i<N+1;i++)
            Arrays.fill(count[i] , Integer.MAX_VALUE);
        for(int r = 1; r <=N ; r++){
            String temp = br.readLine();
            for(int c = 1; c<=M;c++){
                map[r][c] = temp.charAt(c-1) -'0';
            }
        }
        count[1][1] = 1;
        solve(1,1, false);


        for(int i = 1; i<N+1; i++){
            for(int c = 1; c<M+1;c++){
                System.out.print(map[i][c] +" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 1; i<N+1; i++){
            for(int c = 1; c<M+1;c++){
                System.out.print(count[i][c] +" ");
            }
            System.out.println();
        }

        if(count[N][M] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(count[N][M]);
    }

    static void solve(int r, int c, boolean isCrash){

        if(r==N && c ==M)
            return;

        for(int i=0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr <1 || nr > N || nc < 1 || nc > M) continue;



            if(count[nr][nc] == Integer.MAX_VALUE){
                if( map[nr][nc] == 1){

                    if(isCrash){
                        continue;
                    }
                    else{
                        map[nr][nc] = 0;
                        count[nr][nc] = count[r][c] + 1;
                        solve(nr, nc, true);
                        map[nr][nc] = 1;
                    }
                }
                else {
                    count[nr][nc] = count[r][c] + 1;
                    solve(nr, nc, false);
                }
            }
        }
    }
}
