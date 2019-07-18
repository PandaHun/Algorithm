package SWExpertAcademy;

import java.util.*;
import java.io.*;
public class problem1211 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc=1 ;tc<=10;tc++){
            br.readLine();
            int[][] ladder = new int[100][100];
            int result = 0;
            for(int i =0;i<100;i++){
                String[] temp = br.readLine().split(" ");
                for(int j=0;j<100;j++){
                    ladder[i][j] = Integer.parseInt(temp[j]);
                }
            }
            int y = 0;
            for(int i=0;i<100;i++){
                if( ladder[0][i] == 1){
                    y = i;
                    int cnt = 0;
                    for(int j=0;j<100;j++){
                        cnt++;
                    }
                }
            }


//            System.out.println("#"+tc+" "+x);
        }
    }
}
