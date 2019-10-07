package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem2817 {

    private static int T, N, K;
    private static int[] input;
    private static int answer;
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int tc = 1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            input = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            solve(0, 0);

            System.out.println("#"+tc+" "+answer);
        }
    }

    static void solve(int index, int sum){

        if( sum == K){
            answer++;
            return;
        }

        if(sum > K || index > N-1){
            return;
        }

        solve(index+1, sum+input[index]);
        solve(index+1, sum);
    }
}
