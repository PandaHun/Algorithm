package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 소수 & 펠린드롬
 */
import java.io.*;
import java.util.*;

public class problem1747 {
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1500001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i<=1500000; i+=1) {
            for (int j = i * i; j <= 1500000; j += i) {
                isPrime[j] = false;
            }
        }

        int answer = 0;

        for(int i = n; i <=1500000;i++){
            if(isPrime[i]){
                if(isPalindrome(i)) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean isPalindrome(int number){
        String str = String.valueOf(number);
        int len =str.length();

        if(len >2) {
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1))
                    return false;
            }
        }
        else if(len ==2){
            if(str.charAt(0) !=str.charAt(1)) {
                return false;
            }
        }
        return true;
    }
}
