package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class problem16637 {

    private static int N;
    private static int[] numbers, operation;
    private static int answer;
    private static boolean[] isIn;
    private static Deque<Integer> ex;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N/2+1];
        operation = new int[N/2];
        String st = br.readLine();
        numbers[0] = st.charAt(0) - '0';
        for(int i =1 ; i < N; i++) {
            if( i % 2==0) {
                numbers[i/2] = st.charAt(i) - '0';
            } else {
                operation[i/2] = st.charAt(i);
            }
        }
        answer = Integer.MIN_VALUE;
        solve(N/2);
        System.out.println(answer);
    }

    private static void solve(int n) {
        for (int  i = 0 ; i < (1<<n) ; i++) {
            isIn = new boolean[n];
            for(int j = 0 ; j < n ; j++) {
                if ( ((1<<j) & i) > 0) {
                    isIn[j] = true;
                }
            }
            calculate();
        }
    }

    private static void calculate() {
        ex = new LinkedList<>();
        ex.add(numbers[0]);
        for(int i = 0 ; i < N/2; i++) {
            if( isIn[i] ) {
                int temp = ex.pollLast();
                switch (operation[i]) {
                    case '+':
                        ex.add(temp + numbers[i+1]);
                        break;
                    case '-':
                        ex.add(temp - numbers[i+1]);
                        break;
                    case '*':
                        ex.add(temp * numbers[i+1]);
                        break;
                }
                if(i < isIn.length -1) {
                    isIn[i+1] = false;
                }
            }else {
                ex.add(operation[i]);
                ex.add(numbers[i+1]);
            }
        }
        int res = ex.poll();
        while(!ex.isEmpty()) {
            int oper = ex.poll();
            int temp = ex.poll();
            switch (oper) {
                case '+':
                    res += temp;
                    break;
                case '-':
                    res -= temp;
                    break;
                case '*':
                    res *= temp;
                    break;
            }
        }
        answer = Math.max(answer,  res);
    }
}