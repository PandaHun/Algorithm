package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 치킨 배달
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class problem15686 {

    private static int N, M, home;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[] isPicked;
    private static List<Chicken> chickenList;

    private static int answer = Integer.MAX_VALUE;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        home =0;
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        M = Integer.parseInt(st.nextToken());
        chickenList = new LinkedList<>();
        int idx = 1;

        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    chickenList.add(new Chicken(i,j,idx++));
                }
                if(map[i][j] == 1)
                    home++;
            }
        }
        isPicked = new boolean[chickenList.size()];
        solve(0,0);

        System.out.println(answer);
    }

    static void solve(int index, int depth){

        if(depth == M){
            bfs();
            return;
        }

        if(index == chickenList.size())
            return;

        isPicked[index] = true;
        solve(index+1, depth+1);
        isPicked[index] = false;
        solve(index+1, depth);
    }

    static void bfs(){
        boolean[][] visited = new boolean[N][N];
        Queue<Chicken> queue = new LinkedList<>();
        int[][] nmap = new int[N][N];
        for(int i = 0; i < isPicked.length;i++){
            if(isPicked[i]) {
                Chicken now = chickenList.get(i);
                now.idx = 0;
                queue.add(now);
                visited[now.r][now.c] = true;
            }
        }

        int sum = 0;
        int homeSize = home;
        while(!queue.isEmpty()){
            Chicken now = queue.poll();

            for(int k = 0 ; k< 4; k++){
                int nr = now.r +dr[k];
                int nc = now.c +dc[k];

                if(nr < 0 || nc <0 || nr >=N || nc >= N) continue;

                if(visited[nr][nc]) continue;

                if(map[nr][nc] == 0){
                    nmap[nr][nc] = now.idx+1;
                    queue.add(new Chicken(nr,nc,now.idx+1));
                    visited[nr][nc] = true;
                }
                else if( map[nr][nc] == 1){
                    nmap[nr][nc] = now.idx+1;
                    sum+=now.idx+1;
                    homeSize--;
                    queue.add(new Chicken(nr, nc, now.idx+1));
                    visited[nr][nc] = true;
                }else if(map[nr][nc] == 2){
                    nmap[nr][nc] = now.idx+1;
                    queue.add(new Chicken(nr,nc,now.idx+1));
                    visited[nr][nc] = true;
                }
            }

            if(homeSize == 0){
                if(sum < answer)
                    answer = sum;

                return;
            }
        }
    }
}

class Chicken{
    int r;
    int c;
    int idx;

    public Chicken(int r, int c, int idx){
        this.r = r;
        this.c = c;
        this.idx = idx;
    }
}
