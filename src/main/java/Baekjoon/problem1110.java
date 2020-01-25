package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1110 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int origin =  Integer.parseInt(br.readLine());
        int after = 0;
        int before = origin;
        int answer = 0;
        while(true) {
            answer++;
            int sum = (before/10 + before%10) %10;
            after = (before%10) * 10 + sum;
            before = after;
            if( after == origin) {
                break;
            }
        }
        System.out.println(answer);
    }
}
