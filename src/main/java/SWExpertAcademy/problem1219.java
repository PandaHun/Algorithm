package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem1219 {

    static int[] array1 = new int[100];
    static int[] array2 = new int[100];

    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++){
            Arrays.fill(array1, -1);
            Arrays.fill(array2, -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                if(array1[to] == -1)
                    array1[to] = from;
                else
                    array2[to]= from;
            }
            int result  = find(0);
            if( result>=1) result = 1;

            System.out.println("#" + tc +" " + result);
        }
    }
    private static int find(int x){
        if (x== -1 ) return 0;
        else if(x ==99) return 1;
        return find(array1[x]) + find(array2[x]);
    }
}
