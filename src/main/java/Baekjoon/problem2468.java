package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2468 {

    static int[][] map;
    static boolean[][] visited;
    static int N, max, answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        answer = 1;
        for (int i = 1; i < max; i++) {
            visited = new boolean[N][N];
            int k = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] > i && !visited[r][c]) {
                        dfs(r, c, i);
                        k++;
                    }
                }
            }
            answer = Math.max(k, answer);
        }
        System.out.println(answer);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int v) {
        visited[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                if (!visited[nr][nc] && map[nr][nc] > v) {
                    dfs(nr, nc, v);
                }
            }
        }
    }
}
