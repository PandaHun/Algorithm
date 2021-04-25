package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem6549 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            long[] array = new long[n + 2];
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            long ans = 0;
            for (int i = 1; i <= n + 1; i++) {
                while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                    long height = array[stack.peek()];
                    stack.pop();
                    long width = i - stack.peek() - 1;

                    ans = Math.max(ans, width * height);
                }
                stack.push(i);
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
