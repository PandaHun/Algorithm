package SWExpertAcademy;
/*
 *  @Author: Pandahun
 *  @Content: 농작물 수확하기
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2805 {

    private static int T, N;
    private static int[][] map;
    private static int answer;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = 0;
            for (int r = 0; r < N; r++) {
                String temp = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = temp.charAt(c) - '0';
                }
            }

            solve();
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void solve() {

        for (int i = 0; i < N / 2; i++) {
            for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                answer += map[i][j];
            }
        }
        for (int i = N / 2; i >= 0; i--) {
            for (int j = N / 2 - i; j <= N / 2 + i; j++) {
                answer += map[N - 1 - i][j];
            }
        }
    }
}
