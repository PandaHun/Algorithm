package SWExpertAcademy;

import java.util.*;
import java.io.*;
public class problem1210 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc=1 ;tc<=10;tc++){
            br.readLine();
            boolean[][] map = new boolean[100][100];
            int st = 0;
            for(int j=0; j<100; j++){
                String[] temp = br.readLine().split(" ");
                for(int k=0; k<100; k++){
                    switch (temp[k]) {
                        case "1":
                            map[j][k] = true;
                            break;
                        case "2":
                            map[j][k] = true;
                            st = k;
                            break;
                        default:
                            map[j][k] = false;
                            break;
                    }
                }
            }
            int curx = st;
            int h = 99;
            while(h >= 0){
                map[h][curx] = false;
                if(curx-1>=0 && map[h][curx-1]){
                    curx--;
                }else if(curx+1<100 && map[h][curx+1]){
                    curx++;
                }else{
                    h--;
                }
            }
            System.out.println("#"+tc+" "+curx);
        }
    }
}
