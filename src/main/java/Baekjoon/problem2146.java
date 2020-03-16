package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2146 {

    static int N;
    static int[][] island;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        island = new int[N][N];
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                island[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int islandNumber = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] || island[r][c] == 0) {
                    continue;
                }
                setIsland(r, c, islandNumber);
                islandNumber++;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < islandNumber; i++) {
            answer = Math.min(answer, getBridgeLength(i));
        }
        System.out.println(answer);
    }

    static int getBridgeLength(int number) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (island[r][c] == number) {
                    dist[r][c] = 0;
                    queue.add(new int[]{r, c});
                } else if (island[r][c] == 0) {
                    dist[r][c] = -1;
                } else {
                    dist[r][c] = -2;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (dist[nr][nc] == -2) {
                    min = Math.min(min, dist[r][c]);
                    continue;
                } else if (dist[nr][nc] == -1) {
                    queue.add(new int[]{nr,nc});
                    dist[nr][nc] = dist[r][c] + 1;
                }
            }
        }
        return min;
    }

    static void setIsland(int r, int c, int idx) {
        visited[r][c] = true;
        island[r][c] = idx;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || island[nr][nc] == 0) {
                continue;
            }
            setIsland(nr, nc, idx);
        }
    }
}
