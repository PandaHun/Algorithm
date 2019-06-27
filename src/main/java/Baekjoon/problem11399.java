package Baekjoon;

import java.io.*;
import java.util.*;

/*Greedy Algorithms 11399 ATM*/

public class problem11399 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N;i++)
            time[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(time);
        int answer = 0;
        for (int i=0;i<N;i++){
            answer += (N-i)*time[i];
        }
        System.out.println(answer);
    }
}
