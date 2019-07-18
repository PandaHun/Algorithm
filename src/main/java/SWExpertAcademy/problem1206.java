package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class problem1206 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[10];
        for (int tc = 1; tc<=10;tc++){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[num];
            int index =0;
            while(st.hasMoreTokens()){
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            int temp = 0 ;
            for(int i = 2 ;i<num-2;i++){
                int front = Math.max(arr[i+1], arr[i+2]);
                int behind = Math.max(arr[i-1], arr[i-2]);
                temp = Math.max(front, behind);
                if(temp < arr[i])
                    answer[tc-1] +=arr[i] -temp;
            }

            System.out.println("#" +tc +" "+answer[tc-1]);
        }
    }
}
