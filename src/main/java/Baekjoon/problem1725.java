package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem1725 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i <= n + 1; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                int height = array[stack.peek()];
                stack.pop();
                int width = i - stack.peek() - 1;

                ans = Math.max(ans, width * height);
            }
            stack.push(i);
        }
        System.out.println(ans);
    }
}

