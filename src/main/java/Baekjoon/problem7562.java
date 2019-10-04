package Baekjoon;

import java.io.*;
import java.util.*;

public class problem7562 {

    private static int T, N;
    private static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
    private static int[] dc = { -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main( String[] args ) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T;tc++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Node startNode = new Node(r, c, 0 );
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            Node endNode = new Node(r, c, 0);

            bfs(startNode, endNode);
        }
    }
    static void bfs(Node start, Node end){
        boolean[][] visited = new boolean[N][N];

        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty() && !flag){
            for(int i =0;  i<q.size();i++){
                Node now = q.poll();
                if(now.r == end.r && now.c == end.c){
                    System.out.println(now.level);
                    break;
                }

                for(int k = 0 ; k<dr.length ;k++){
                    int nr = now.r +dr[k];
                    int nc = now.c +dc[k];
                    int lv =  now.level;

                    if(nr>= 0 && nr < N && nc >=0 && nc <N && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new Node(nr, nc, lv+1));
                    }
                }
            }
        }
    }
}

class Node{
    int r;
    int c;
    int level;

    public Node(int r, int c, int level ){
        this.r = r;
        this.c = c;
        this.level = level;
    }
}
