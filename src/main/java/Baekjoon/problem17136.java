package Baekjoon;

import java.io.*;
import java.util.*;

public class problem17136 {
    static int[][] arr;
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    final static int N = 10;
    static int oneCount = 0, answer =Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                oneCount +=arr[i][j];
            } //End of For j
        }//End of For i

        solve(0, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1: answer);
    }//End of Main

    static void solve(int row, int count, int total){
        if (answer<=count) return;
        if( total == oneCount){
            answer = Math.min(answer, count);
            return ;
        }//End of IF

        for(int i=row;i<N;i++){
            for (int j=0;j<N;j++){

                if(arr[i][j] == 1){
                    boolean flag  =false;

                    for(int k=5;k>=1;k --){

                        if( (i+k) <= N && (j+k) <=N && paperCount[k] > 0 ){
                            if(!flag) {
                                flag = check(i, j, k);
                            }

                            if(flag){
                                setPaste(i, j, k);
                                paperCount[k]--;
                                solve(i, count +1, total + k*k);
                                paperCount[k]++;
                                setPaste(i, j, k);
                            }
                        }
                    }//End of For K
                    if(!flag)
                        return ;
                } //End of if
                if(arr[i][j] == 1)
                    return ;
            } //End of For j
        }//End of For i

    }//End of Solve

    static boolean check(int row, int col, int size){

        for(int i= row; i<row+size;i++){
            for(int j = col; j<col+size;j++){
                if (arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }//End of Check

    static void setPaste(int row, int col, int size){
        for(int i= row; i<row+size;i++){
            for(int j=col; j<col+size ;j++){
                arr[i][j] = arr[i][j]^1;
            }
        }
    }
}
