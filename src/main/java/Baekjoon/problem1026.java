package Baekjoon;

import java.io.*;
import java.util.*;

public class problem1026 {

    static int N;
    static int[] A,B;
    static int S = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0;i<N;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        for(int i=0;i<N;i++){
            temp += A[i]*B[i];
        }
        S = S < temp ? S : temp;
        Arrays.sort(A);
        Arrays.sort(B);
        temp = 0;
        for(int i=0;i<N;i++){
            temp += A[i] * B[N-1-i];
        }
        S = S < temp ? S : temp;
        System.out.println(S);
    }
}
