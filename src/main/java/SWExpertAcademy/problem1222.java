package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem1222 {
    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1;tc<=10;tc++){
            int num = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            int answer = 0;
            for(int i=0;i<num;i++){
                char temp = arr.charAt(i);
                if (temp != '+')
                    answer+= temp-48;
            }

            System.out.println("#" +tc+" "+answer);
        }
    }
}
