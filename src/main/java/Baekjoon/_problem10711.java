package Baekjoon;

import java.io.*;
import java.util.*;

public class _problem10711 {

    static int h,w;
    static int[][] arr, narr;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        narr = new int[h][w];
        for(int i=0;i<h;i++){
            String temp = br.readLine();
            for(int j=0;j<w;j++){
                arr[i][j] = temp.charAt(j) - '0';
                narr[i][j] = arr[i][j];
            }
        }
        boolean flag =false;
        int answer = -1;
        while(!flag){
            copyArr();
            answer++;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){

                    if( arr[i][j]!=0){
                        int current = arr[i][j];
                        int count = 0;
                        for(int k = 0;k<8;k++){
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if (arr[ny][nx] == 0)
                                count++;
                        }
                        if(count >=current)
                            narr[i][j] = 0;
                    }
                }
            }
            if(check())
                break;
        }
        System.out.println(answer);
    }

    static void copyArr(){
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                arr[i][j] = narr[i][j];
            }
        }
    }

    static boolean check(){
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(arr[i][j] != narr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
