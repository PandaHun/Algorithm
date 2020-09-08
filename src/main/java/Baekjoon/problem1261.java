package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1261 {

    static int R, C;
    static int[][] map, dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dist = new int[R][C];
        for (int i = 0; i < R; i++) {
            String t = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = t.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        dijkstra();
        System.out.println(dist[R-1][C-1]);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                    if (dist[nr][nc] > dist[now[0]][now[1]] + map[nr][nc]) {
                        dist[nr][nc] = dist[now[0]][now[1]] + map[nr][nc];
                        pq.add(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }
        }
    }
}
