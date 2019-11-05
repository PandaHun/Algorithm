package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 로봇 프로젝트
 */
import java.io.*;
import java.util.*;

public class problem3649 {

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        while((read = br.readLine()) !=null) {
            int x = Integer.parseInt(read);
            int n = Integer.parseInt(br.readLine());
            int[] legos = new int[n];
            for (int i = 0; i < n; i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }
            x = x * (int) Math.pow(10, 7);
            Arrays.sort(legos);
            solve(legos, x);
        }
    }

    static void solve(int[] legos, int x){
        int left = 0 ;
        int right = legos.length-1;
        int[] length = new int[2];
        while(left<right){
            int sum = legos[left] + legos[right];

            if(sum == x){
                length[0] = legos[left];
                length[1] = legos[right];
                break;
            }
            else if( sum < x){
                left++;
            }
            else if( sum > x){
                right--;
            }
        }

        if(length[0]!=0 && length[1]!=0){
            System.out.println("yes " + length[0] +" " +length[1]);
        }
        else
            System.out.println("danger");
    }
}

