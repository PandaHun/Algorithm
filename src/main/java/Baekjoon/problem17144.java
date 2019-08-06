package Baekjoon;

import java.util.*;
import java.io.*;
public class problem17144 {
    static int R, C, T;
    static int[][] map, nmap;
    static int answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int targetPosition = 0;
        answer = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==-1){
                    targetPosition = i;
                }
            }
        }
        targetPosition --;
        for(int i=0;i<T;i++){
            spread();
            clean(targetPosition);
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] >0)
                    answer +=map[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void spread(){
        nmap = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] > 0){
                    int cnt =0;
                    for(int k=0;k<4;k++){
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if( nx < 0 || ny <0 || nx >C-1 || ny>R-1 || map[ny][nx] == -1)
                            continue;

                        nmap[ny][nx] += map[i][j] /5;
                        cnt++;
                    }
                    nmap[i][j] += map[i][j] - (map[i][j]/5)*cnt;
                }
                else if( map[i][j] == -1){
                    nmap[i][j] = -1;
                }
            }
        }
        for(int i=0;i<R;i++){
            map[i] = Arrays.copyOf(nmap[i], C);
        }
    }

    public static void clean(int position){
        int up = position;
        int down = position+1;

        for(int i=0;i<C-1;i++){
            if(map[up][i] == -1 || nmap[down][i] == -1){
                map[up][i+1] = 0;
                map[down][i+1] = 0;
            }
            else{
                map[up][i+1] = nmap[up][i];
                map[down][i+1] =  nmap[down][i];
            }
            map[0][i] = nmap[0][i+1];
            map[R-1][i] = nmap[R-1][i+1];
        }

        for(int i=0;i<R-1;i++){
            if(i<up){
                map[i+1][0] = nmap[i][0];
                map[i][C-1] =  nmap[i+1][C-1];
            }
            else if(i>=down){
                map[i][0] = nmap[i+1][0];
                map[i+1][C-1] = nmap[i][C-1];
            }
        }

        map[up][0] = -1;
        map[down][0] = -1;
    }
}
