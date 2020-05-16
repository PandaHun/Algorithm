package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] prime = new boolean[N + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) {
                list.add(i);
                for (int j = i * 2; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        int len = list.size();
        int max, min, sum, answer;
        sum = answer = max = min = 0;
        for (; max < len; max++) {
            sum += list.get(max);
            while (sum > N) {
                sum -= list.get(min++);
            }
            if (N == sum) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}