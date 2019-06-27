package Baekjoon;

import java.util.*;
import java.io.*;

/*Greedy Algorithms 11047 동전0*/
public class problem11047 {
    static int N;
    static int K;
    static int count = 0;
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        for (int i=0;i<N;i++)
            coin[i] = Integer.parseInt(br.readLine());
        int index = -1;
        for (int i = N-1;i>=0;i--)
            if (coin[i] < K) {
                index = i;
                break;
            }
        for (int i=index; i>=0; i--){
            if (K==0)
                break;
            int temp = K/coin[i];
            count += temp;
            K %= coin[i];
        }

        System.out.println(count);
    }
}
