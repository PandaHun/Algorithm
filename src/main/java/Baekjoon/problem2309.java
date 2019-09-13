package Baekjoon;

import java.util.*;
import java.io.*;
public class problem2309 {

    static int N = 9;
    static int sum;
    public static void main( String[] args ) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[N];
        sum = 0;
        //Get Input
        for(int i = 0; i<N;i++){
            heights[i] = Integer.parseInt(br.readLine());
        }

        for(int height : heights){
            sum+=height;
        }
        //Logic
        boolean flag = false;
        for(int i=0;i<N;i++){
            if(flag) break;
            for(int j=0;j<N;j++){
                if ( i == j){
                    continue;
                }

                if(sum - heights[i] - heights[j] == 100){
                    heights[i] = -1;
                    heights[j] = -1;
                    flag = true;
                    break;
                }
            }
        }
        Arrays.sort(heights);
        for(int h : heights){
            if(h!=-1)
                System.out.println(h);
        }
    }

}
