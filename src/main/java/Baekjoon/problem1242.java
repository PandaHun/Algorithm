package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1242 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long answer = 0;
        while (true) {
            long tmp = 0;
            if (m % k == 0) {
                answer += m / k;
                break;
            } else {
                tmp = n % k;
                answer += n / k;
                n -= n / k;
                m = m - m / k + tmp;
            }
        }
        System.out.print(answer);
    }
}
