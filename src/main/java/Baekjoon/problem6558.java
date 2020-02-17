package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class problem6558 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i < 1000001; i ++) {
            isPrime[i] = true;
        }
        for(int i = 2; i*i < 1000001; i++) {
            for(int j = i*2; j < 1000001; j+=i) {
                isPrime[j] = false;
            }
        }
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                break;
            }
            boolean flag = false;
            int answer = 0;
            for(int i = 2; i <=num; i++) {
                if( isPrime[i] && isPrime[num-i]) {
                    flag = true;
                    answer = i;
                    break;
                }
            }
            if(flag) {
                bw.write(num +" = " + answer + " + " + (num - answer) + "\n");
            }else {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.flush();
    }
}
