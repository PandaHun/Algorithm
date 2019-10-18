package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: Puyo Puyo
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class problem11559 {

    private static int N = 12, M = 6;
    private static char[][] map = new char[12][6];
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int answer = 0;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 12; r++) {
            String temp = br.readLine();
            map[r] = temp.toCharArray();
        }


        while (true) {

            pang();
            down();

            if(!flag)
                break;
            else
                flag = false;
        }
        System.out.println(answer);
    }

    static void pang() {
        Queue<Block> queue = new LinkedList<>();
        Queue<Block> removed = new LinkedList<>();
        boolean isFull = false;
        for (int r = N - 1; r >= 0; r--) {

            for (int c = 0; c < M; c++) {
                if (map[r][c] != '.') {
                    boolean[][] visited = new boolean[N][M];

                    queue.add(new Block(r, c, map[r][c]));
                    removed.add(new Block(r, c, map[r][c]));

                    visited[r][c] = true;
                    int cnt = 1;
                    while (!queue.isEmpty()) {
                        Block now = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = now.r + dr[k];
                            int nc = now.c + dc[k];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                            if (visited[nr][nc]) continue;

                            if (map[nr][nc] == map[r][c]) {
                                visited[nr][nc] = true;
                                queue.add(new Block(nr, nc, map[nr][nc]));
                                removed.add(new Block(nr, nc, map[nr][nc]));
                                cnt++;
                            }
                        }
                    }

                    if (cnt >= 4) {
                        isFull = true;

                        while (!removed.isEmpty()) {
                            Block now = removed.poll();
                            map[now.r][now.c] = '.';
                        }
                    } else {
                        removed.clear();
                    }


                }
            }
        }
        if (isFull) {
            answer++;
        }
    }

    static boolean flag = false;
    static void down() {

        for(int r = N-1; r>=0 ; r--){

            for(int c = 0 ; c<M;c++){
                if(map[r][c] =='.'){
                    for(int nr = r; nr>=0; nr--){
                        if(map[nr][c] !='.'){
                            flag =true;
                            map[r][c] = map[nr][c];
                            map[nr][c] ='.';
                            break;
                        }
                    }
                }
            }
        }
    }
}

class Block {
    int r;
    int c;
    char color;

    public Block( int r, int c, char color ) {
        this.r = r;
        this.c = c;
        this.color = color;
    }
}