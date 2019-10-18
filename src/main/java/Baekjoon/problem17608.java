package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 막대기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem17608 {

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for(int i = 0; i < N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int answer = 1;
        int max = input[N-1];
        for(int i = N - 2; i>=0 ; i--){
            if(input[i] > max){
                max = input[i];
                answer++;
            }
        }

        System.out.println(answer);

    }
}
