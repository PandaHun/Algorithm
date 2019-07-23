package SWExpertAcademy;

import java.io.*;
import java.util.*;
public class problem1217 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[11];
        for(int tc = 1;tc<=10;tc++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            answer[tc] = nPower(n, m);
            System.out.println("#" +tc+ " "+ answer[tc]);
        }
    }
    public static int nPower(int n, int m){
        if(m<2)
            return n ;
        else
            return n * nPower(n, m-1);
    }
}
