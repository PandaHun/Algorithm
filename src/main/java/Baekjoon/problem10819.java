package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 차이를 최대로
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10819 {

    private static int[] input;
    private static int N, answer;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        answer = -1;
        permutation(0);
        System.out.println(answer);
    }

    static void permutation( int depth ) {

        if (depth == N - 1) {
            int result = 0;
            for (int i = 0; i < N - 1; i++) {
                result += Math.abs(input[i] - input[i + 1]);
            }
            if (result > answer) {
                answer = result;
            }
        }

        for (int i = depth; i < N; i++) {
            int temp = input[depth];
            input[depth] = input[i];
            input[i] = temp;
            permutation(depth + 1);

            temp = input[depth];
            input[depth] = input[i];
            input[i] = temp;
        }

    }
}
