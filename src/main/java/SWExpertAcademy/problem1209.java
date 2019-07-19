package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem1209 {
    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10;tc++){
            int answer = 0;
            int[][] arr = new int[100][100];

            br.readLine();
            for(int i=0;i<100;i++){
                String[] temp = br.readLine().split(" ");
                arr[i] = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            }
            int max = -1;
            int dig = 0, dig2=0;
            for(int i=0;i<100;i++){
                int row = 0, col = 0;
                for(int j=0;j<100;j++){
                    row += arr[i][j];
                    col += arr[j][i];
                    if(i==j)
                        dig +=arr[i][j];
                    else if( i+j==99)
                        dig2 +=arr[i][j];
                }
                int temp = Math.max(row, col);
                max = Math.max(temp, max);
            }
            answer = Math.max(Math.max(dig,dig2), max);
            System.out.println("#" +tc+" "+ answer);
        }
    }
}
