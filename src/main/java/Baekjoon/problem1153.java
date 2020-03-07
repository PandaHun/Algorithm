package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1153 {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N + 1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = 2; j * i <= N; j ++) {
                isPrime[j * i] = true;
            }
        }
        if (N < 9) {
            System.out.println(-1);
        } else {
            if (N % 2 == 1) {
                System.out.print("2 3 ");
                N -= 5;
                find(N);
            }
            else {
                System.out.print("2 2 ");
                N -=4;
                find(N);
            }
        }
    }

    static void find(int N) {
        for(int i = 2; i <= (N>>1); i++) {
            if(!isPrime[i] && !isPrime[N-i]) {
                System.out.print(i +" " + (N - i) +"\n");
                break;
            }
        }
    }
}
