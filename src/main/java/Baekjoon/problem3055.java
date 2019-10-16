package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 탈출
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem3055 {

    private static int R, C;
    private static char[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static Queue<Biber> queue;
    private static Queue<Biber> waters;

    public static  void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int moveCount = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        queue = new LinkedList<>();
        waters = new LinkedList<>();

        for(int r =0; r<R;r++){
            String temp = br.readLine();
            for(int c = 0; c<C;c++){
                map[r][c] = temp.charAt(c);
                if(map[r][c] =='*')
                    waters.add(new Biber(r,c));

                if (map[r][c] =='S')
                    queue.add(new Biber(r,c));
            }
        }
        while(true){
            ++moveCount;
            if(queue.isEmpty()){
                System.out.println("KAKTUS");
                return;
            }

            flood();
            if(moveBiber()){
                System.out.println(moveCount);
                return;
            }

        }
    }
    static boolean moveBiber(){
        int size = queue.size();

        for(int k = 0 ; k<size;k++){
            Biber now = queue.poll();

            for(int i = 0 ; i< 4;i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if( nr>=0 && nr < R && nc >=0 && nc <C){
                    if(map[nr][nc] == 'D'){
                        queue.add(new Biber(nr,nc));
                        return true;
                    }
                    else if(map[nr][nc] == '.'){
                        map[nr][nc] = 'S';
                        queue.add(new Biber(nr,nc));
                    }
                }

            }
        }
        return false;
    }
    static void flood(){
        int size = waters.size();
        for(int t= 0 ; t<size;t++){
            Biber now = waters.poll();

            for(int i=0;i<4;i++){
                int nr = now.r +dr[i];
                int nc = now.c +dc[i];

                if( nr>=0 && nr < R && nc >=0 && nc <C){
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = '*';
                        waters.add(new Biber(nr,nc));
                    }
                }
            }
        }
    }
}

class Biber{
    int r;
    int c;
    public Biber(int r, int c){
        this.r = r;
        this.c = c;
    }
}