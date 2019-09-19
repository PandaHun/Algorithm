package Baekjoon;


import java.io.*;
import java.util.*;

public class problem1018 {

    static int N, M;
    static String[] map;
    static int min = Integer.MAX_VALUE;
    static String[] Wresult = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
    static String[] Bresult = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];

        for(int i=0;i<N;i++){
            map[i] = br.readLine();
        }
        /*
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }*/

        for(int i=0;i+7<N;i++){
            for(int j=0;j+7<M;j++){
                min = Math.min(min, solve(i,j));
            }
        }

        System.out.println(min);
    }

    static int solve(int r, int c){
        int result = 0;
        for(int i=r;i<r+8;i++){
            for(int j=c;j<c+8;j++){
                if(map[i].charAt(j)==Wresult[i-r].charAt(j-c))
                    result++;
            }
        }
        int result2 =0;
        for(int i=r;i<r+8;i++){
            for(int j=c;j<c+8;j++){
                if(map[i].charAt(j)==Bresult[i-r].charAt(j-c))
                    result2++;
            }
        }
        return Math.min(result, result2);

    }
}
