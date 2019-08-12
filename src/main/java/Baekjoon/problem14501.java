package Baekjoon;

import java.io.*;
import java.util.*;

public class problem14501 {
    static int[] time, price;
    static boolean[] visited;
    static int n, profit;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        profit = 0;
        time = new int[n+1];
        price = new int[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, 0);
        System.out.println(profit);
        br.close();
    }
    static void solve(int x, int sum){
        if(x == n+1 ){
            profit = Math.max(profit, sum);
            return ;
        }
        if (x + time[x] <= n+1)
            solve( x+time[x], sum + price[x]);
        if (x +1 <=n+1)
            solve(x+1, sum);
    }

}
