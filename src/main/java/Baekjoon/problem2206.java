package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2206 {

    private static int N, M;
    private static int[][] map, visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        answer = Integer.MAX_VALUE;
        bfs();
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int dist = now[2];
            int crash = now[3];
            if( r == N-1 && c == M-1) {
                answer = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (visited[nr][nc] <= crash) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    visited[nr][nc] = crash;
                    q.add(new int[]{nr, nc, dist + 1, crash});
                } else {
                    if (crash == 0) {
                        visited[nr][nc] = crash + 1;
                        q.add(new int[]{nr, nc, dist + 1, crash + 1});
                    }
                }
            }

        }
    }
}