package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class problem1915 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        int[][] dp = new int[N][M];
        int answer = Integer.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            for(int c = 0; c< M; c++) {
                int temp = Integer.MAX_VALUE;
                if(map[r][c] == 1) {
                    if( r -1 >=0 && c -1 >=0 ) {
                        temp = Math.min(temp, dp[r][c - 1]);
                        temp = Math.min(temp, dp[r - 1][c - 1]);
                        temp = Math.min(temp, dp[r - 1][c]);
                    }
                    if(temp == Integer.MAX_VALUE){
                        dp[r][c] = 1;
                    }else {
                        dp[r][c] = temp +1;
                    }
                    answer = Math.max(answer ,dp[r][c]);
                }

            }
        }
        System.out.println(answer * answer);
    }
}
