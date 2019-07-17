import java.io.*;
import java.util.*;


public class problem1240 {
    public static void main( String[] args ) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m,answer = 0;
        String[] code = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
        String str, tmp, sub = "";
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[8];
        for (int tc = 1; tc<=T; tc++){
            int cnt = 0;
            boolean find = false;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for(int i = 0 ;i<n;i++){
                str = br.readLine();
                for(int j = m-1; j>0 && !find ; j--){
                    if(str.charAt(j) == '1'){
                        sub = str.substring(j-55, j+1);
                        find = true;
                    }
                }
            }

            for (int i = 0 ; i<sub.length(); i+=7){
                tmp = sub.substring(i,i+7);
                for (int j = 0 ; j<code.length; j++){
                    if( tmp.equals(code[j])){
                        arr[cnt++] = j;
                    }
                }
            }

            answer = (arr[0]+arr[2]+arr[4]+arr[6])*3 + (arr[1] +arr[3] +arr[5]) + arr[7];
            if (answer %10 ==0){
                answer = 0;
                for(int i : arr)
                    answer+=i;
            }
            else {
                answer = 0;
            }
            System.out.println("#" + tc +" " + answer);
        }
    }
}