package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2003 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > K) {
                continue;
            }
            if (arr[i] == K) {
                answer++;
            }
            int sum = arr[i];
            for (int j = i + 1; j < N; j++) {
                sum += arr[j];
                if (sum >= K) {
                    if (sum == K) {
                        answer++;
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
