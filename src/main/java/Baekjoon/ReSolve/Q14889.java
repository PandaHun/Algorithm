package Baekjoon.ReSolve;
/*
 *  @Author: Pandahun
 *  @Content: 스타트와 링크
 *  @Try: 2nd
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {

    private static int N;
    private static int[][] status;
    private static boolean[] picked;
    private static int answer = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        status = new int[N + 1][N + 1];
        picked = new boolean[N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c <= N; c++) {
                status[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        solve(1, 0);
        System.out.println(answer);
    }

    static void solve( int idx, int depth ) {
        if (answer == 0) return;
        if (depth == N / 2) {
            int tmp = setAnswer();
            answer = answer > tmp ? tmp : answer;
        }
        if (idx == N)
            return;

        for (int i = idx; i <= N; i++) {
            if (!picked[i]) {
                picked[i] = true;
                solve(i + 1, depth + 1);
                picked[i] = false;
            }
        }
    }

    static int setAnswer() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (picked[i] && picked[j])
                    startSum += status[i][j];

                if (!picked[i] && !picked[j])
                    linkSum += status[i][j];
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
