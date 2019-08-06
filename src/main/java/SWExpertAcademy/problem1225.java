package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class problem1225 {
    public static void main(String[] args) throws  IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1;tc<=10;tc++){
            String answer = "";
            br.readLine();
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            boolean flag = false;
            int temp = 1;
            while(temp!=0){

                for(int i = 1;i<6 ; i++){
                    temp = q.poll();
                    temp = temp -i;
                    if( temp<0)
                        temp = 0;

                    q.add(temp);
                    if(temp ==0)
                        break;
                }
            }
            for (int i=0;i<8;i++){
                answer += q.poll()+" ";
            }
            System.out.println("#" +tc+" " + answer);
        }
    }
}
