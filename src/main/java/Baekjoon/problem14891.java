package Baekjoon;

import java.util.*;
import java.io.*;

public class problem14891 {
    static int[][] input;

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        input = new int[4][8];
        for(int i =0; i<4;i++){
            String str = br.readLine().trim();
            for(int j=0;j<8;j++){
                input[i][j] = str.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken())-1;
            String direction = st.nextToken();

            if(direction.equals("1")){  //시계방향
                if(num-1>=0 && input[num][6] != input[num-1][2])    //만약 내 왼쪽이 돌 수 있으면
                    leftRotate(num-1, false);   //반시계로 돌리자
                rightRotate(num, true); //우선 나는 시계방향
            }
            if(direction.equals("-1")){ //반시계 방향
                if(num+1<4 && input[num][2] !=input[num+1][6])  //만약 내 오른쪽이 돌 수 있으면
                    rightRotate(num+1, true); //시계로
                leftRotate(num, false); //나는 반시계로
            }
        }
        int sum = 0;
        for(int i=0;i<4;i++){
            if(input[i][0]== 1)
                sum+=Math.pow(2, i);
        }

        System.out.println(sum);
    }

    static void rightRotate(int idx, boolean flag){ //false 반시계, true 시계
        if(flag){
            if(idx+1 < 4 && input[idx][2] !=input[idx+1][6])
                leftRotate(idx+1, true);
        }
        else{
            if(idx -1 >=0 && input[idx][6] != input[idx-1][2])
                leftRotate(idx-1, false);
        }
        int temp = input[idx][7];
        for(int i=7;i>0;i--)
            input[idx][i] = input[idx][i-1];
        input[idx][0] = temp;
    }

    static void leftRotate(int idx, boolean flag) {
        if (flag) {
            if (idx + 1 < 4 && input[idx][2] != input[idx + 1][6])
                rightRotate(idx + 1, true);
        } else {
            if (idx - 1 >= 0 && input[idx][6] != input[idx - 1][2])
                rightRotate(idx - 1, false);
        }
        int temp = input[idx][0];
        for (int i = 0; i < 7; i++)
            input[idx][i] = input[idx][i + 1];
        input[idx][7] = temp;
    }
}
