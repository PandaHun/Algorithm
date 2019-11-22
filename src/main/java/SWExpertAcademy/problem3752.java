package SWExpertAcademy;
/*
 *  @Author: Pandahun
 *  @Content: 가능한 시험 점수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3752 {

    private static int n, answer;
    private static int[] scores;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            scores = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }

            boolean[] dp = new boolean[sum + 10];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int k = sum; k >= 0; k--) {
                    if (dp[k]) {
                        dp[scores[i] + k] = true;
                    }
                }
            }
            for (int i = 0; i <= sum; i++) {
                if (dp[i])
                    answer++;
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
