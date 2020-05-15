package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2636 {

    static int R, C, answer, cheeze;
    static int[][] map;
    static boolean[][] visited, edges;
    static List<Integer> cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        edges = new boolean[R][C];
        cnt = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cheeze += map[i][j];
            }
        }
        cnt.add(cheeze);
        while (cheeze > 0) {
            answer++;
            melt();
        }
        System.out.println(answer);
        System.out.println(cnt.get(answer - 1));
    }

    static void melt() {
        visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        edges[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] != 1) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    edges[nr][nc] = true;
                }
            }
        }

        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isEdge(i, j)) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) {
                    if (map[i][j] == 1) {
                        cheeze--;
                    }
                    map[i][j] = 0;
                    edges[i][j] = true;
                }
            }
        }
        cnt.add(cheeze);
    }

    static boolean isEdge(int r, int c) {
        int nr, nc;
        for (int k = 0; k < 4; k++) {
            nr = r + dr[k];
            nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                continue;
            }
            if (edges[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}
