package Baekjoon;

import java.io.*;

public class problem9095 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            bw.write(dp[n] + "\n");
        }
        bw.flush();
    }
}
