package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem1228 {

    public static void main( String[] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=10;tc++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<n;i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int operNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                String operator = st.nextToken();
                int operIndex = Integer.parseInt(st.nextToken());
                int operLength = Integer.parseInt(st.nextToken());
                for(int i=0;i<operLength;i++){
                    arr.add(operIndex +i, Integer.parseInt(st.nextToken()));
                }
            }
            String temp ="";
            for(int i=0;i<10;i++){
                temp+=arr.get(i)+" ";
            }
            sb.append("#").append(tc).append(" ").append(temp).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}