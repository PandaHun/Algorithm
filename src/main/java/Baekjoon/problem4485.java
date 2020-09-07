package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem4485 {

    static int N;
    static int[][] map, dist;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static PriorityQueue<Ins> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            dist = new int[N][N];
            pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = map[0][0];
            pq.add(new Ins(0, 0, map[0][0]));
            dijkstra();

            bw.write("Problem " + T + ": " + dist[N - 1][N - 1] + "\n");
        }
        bw.close();
    }

    private static void dijkstra() {
        while (!pq.isEmpty()) {
            Ins now = pq.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if ( dist[nr][nc] > dist[now.r][now.c] + map[nr][nc]) {
                        dist[nr][nc] = dist[now.r][now.c] + map[nr][nc];
                        pq.add(new Ins(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
    }
}

class Ins implements Comparable<Ins> {

    int r;
    int c;
    int distance;

    public Ins(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }

    @Override
    public int compareTo(Ins o) {
        return this.distance - o.distance;
    }
}