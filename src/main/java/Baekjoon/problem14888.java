package Baekjoon;

import java.io.*;
import java.util.*;


public class problem14888 {
    static int n;
    static int[] input;
    //+ - * /
    static int[] operator = new int[4];
    static ArrayList<Integer> list;
    static int max, min;
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new int[n];
        max = -1;
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            input[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++)
            operator[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        solve(1, input[0]);

        Collections.sort(list);
        max = list.get(list.size() - 1);
        min = list.get(0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    static void solve(int x, int sum){
        for(int i=0;i<4;i++){

            if( operator[i] !=0){
                operator[i]--;

                switch (i){

                    case 0:
                        solve(x+1, sum +input[x]);
                        break;
                    case 1:
                        solve(x+1, sum - input[x]);
                        break;
                    case 2:
                        solve(x+1, sum * input[x]);
                        break;
                    case 3:
                        solve(x+1, sum / input[x]);
                        break;
                }
                operator[i]++;
            }
        }

        if( x == n){
            list.add(sum);
        }

    }
}
