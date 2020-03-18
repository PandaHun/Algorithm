package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10986 {

    static int N, M, answer;
    static long[] numbers, dp;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        numbers = new long[N + 1];
        dp = new long[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int in = Integer.parseInt(st.nextToken());
            numbers[i] = (numbers[i - 1] + in) % M;
            dp[(int) numbers[i]]++;
            if (numbers[i] == 0) {
                answer++;
            }
        }
        for (int i = 0; i < M; i++) {
            answer += dp[i] * (dp[i] - 1) / 2;
        }
        System.out.println(answer);
    }
}
