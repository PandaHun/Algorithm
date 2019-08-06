package Baekjoon;

import java.util.*;
import java.io.*;
public class problem17070 {
    static int n;
    static int answer;
    static int[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n =Integer.parseInt(br.readLine());
        if(n<3 || n>16){
            System.out.println("0");
            return ;
        }
        map = new int[n][n];
        answer = 0;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,1);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int dir){
        if( y== n-1 && x==n-1) {
            answer++;
            return;
        }

        int[] direction = getType(dir);

        for(int i=0;i<direction.length;i++){

            int ny = y + dy[direction[i]];
            int nx = x + dx[direction[i]];

            if(ny<0 || ny>n-1 || nx<0 || nx>n-1 || map[ny][nx]!=0) continue;

            if (direction[i] == 2 && (map[y][x+1] != 0 || map[y+1][x] !=0)) continue;

            dfs(ny, nx, direction[i]);
        }
    }

    public static int[] getType(int type){
        if(type == 0) { //세로
            int[] ret = {0,2};
            return ret;
        }
        if(type == 1) { //가로
            int[] ret = {1,2};
            return ret;
        }
        if(type ==2) {
            int[] ret = {0,1,2};
            return ret;
        }
        return null;
    }
}
