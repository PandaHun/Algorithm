package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1520 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map, dp;
    static int R, C;

    static int find(int r, int c) {
        if (r == R - 1 && c == C - 1) {
            return 1;
        }
        if (dp[r][c] == -1) {
            dp[r][c] = 0;
            if (r > 0 && map[r][c] > map[r - 1][c]) {
                dp[r][c] += find(r - 1, c);
            }
            if (c > 0 && map[r][c] > map[r][c - 1]) {
                dp[r][c] += find(r, c - 1);
            }
            if (r < R - 1 && map[r][c] > map[r + 1][c]) {
                dp[r][c] += find(r + 1, c);
            }
            if (c < C - 1 && map[r][c] > map[r][c + 1]) {
                dp[r][c] += find(r, c + 1);
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(find(0, 0));
    }
}
