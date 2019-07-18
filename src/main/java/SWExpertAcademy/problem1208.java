package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class problem1208 {
    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[10];

        for (int tc = 1; tc<=10;tc++){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            int[] arr = new int[100];
            while(st.hasMoreTokens()){
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for (int i=0;i<num;i++){
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            answer[tc-1] = arr[99] -arr[0];

            System.out.println("#" +tc +" "+answer[tc-1]);
        }
    }

}
