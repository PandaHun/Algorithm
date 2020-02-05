package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1806 {

    private static int N;
    private static int S;
    private static int[] numbers;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        long sum = 0;
        int min = N + 1;
        for (; start < N; start++) {
            while (sum < S && end < N) {
                sum += numbers[end++];
            }
            if (sum >= S) {
                min = Math.min(min, end - start);
            }
            sum -= numbers[start];
        }
        if (min == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
