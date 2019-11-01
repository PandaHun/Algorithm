package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 전화번호 목록
 */

import java.io.*;
import java.util.*;

public class problem5052 {

    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            boolean isAble  = true;
            int N = Integer.parseInt(br.readLine());
            String[] input = new String[N];
            for(int i = 0 ; i < N ;i++){
                input[i] = br.readLine();
            }
            Arrays.sort(input);

            for(int i = 0 ; i < N-1 ; i++){
                int now =  input[i].length();
                int next = input[i+1].length();

                if(now < next){
                    if(input[i+1].indexOf(input[i]) > -1 ){
                        isAble = false;
                        break;
                    }
                }
            }
            if(isAble)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }
}