package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2579 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        long[] dp = new long[N+1];
        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if( N >=2) {
            dp[2] = arr[1] + arr[2];
        }
        for(int i = 3; i < N+1; i++) {
            long a = arr[i] + arr[i-1] + dp[i-3];
            long b = arr[i] + dp[i-2];
            dp[i] = Math.max(a,b);
        }
        System.out.println(dp[N]);
    }
}
