package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem14499 {

    static int[] dc = {1, -1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int[] dice = new int[7];
    static int[][] map;
    public static void main( String[] args ) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<K;i++){
            int direction = Integer.parseInt(st.nextToken());
            int nr = dr[direction-1] + R;
            int nc = dc[direction-1] + C;

            if( 0<=nr && 0<=nc && nr < N && nc <M){
                changeDice(direction);

                if (map[nr][nc] == 0){
                    map[nr][nc] = dice[6];
                }else{
                    dice[6] = map[nr][nc];
                    map[nr][nc] = 0;
                }

                R = nr;
                C = nc;
                sb.append(dice[1]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void changeDice(int direction){
        int[] temp = dice.clone();
        //동 1 서 2 북 3 남 4
        if(direction == 1){
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        }
        else if(direction == 2){
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        }
        else if(direction ==3){
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        }
        else if(direction ==4){
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }
}
