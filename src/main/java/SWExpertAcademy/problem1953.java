package SWExpertAcademy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1953 {

    static int N, M, L, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N][M];
            answer = 1;
            bfs(R, C);
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    static void bfs(int startR, int startC) {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        while (!queue.isEmpty()) {
            if (++time >= L) {
                return;
            }
            int len = queue.size();
            for (int s = 0; s < len; s++) {
                int[] cur = queue.poll();
                int now = map[cur[0]][cur[1]];
                for (int k = 0; k < 4; k++) {
                    int nr = cur[0] + dr[k];
                    int nc = cur[1] + dc[k];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        continue;
                    }
                    if (visited[nr][nc] || map[nr][nc] == 0) {
                        continue;
                    }
                    int next = map[nr][nc];
                    switch (k) {
                        case 0:
                            if (now == 1 || now == 2 || now == 4 || now == 7) {
                                if (next == 1 || next == 2 || next == 5 || next == 6) {
                                    queue.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    answer++;
                                }
                            }
                            break;
                        case 1:
                            if (now == 1 || now == 2 || now == 5 || now == 6) {
                                if (next == 1 || next == 2 || next == 4 || next == 7) {
                                    queue.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    answer++;
                                }
                            }
                            break;
                        case 2:
                            if (now == 1 || now == 3 || now == 6 || now == 7) {
                                if (next == 1 || next == 3 || next == 4 || next == 5) {
                                    queue.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    answer++;
                                }
                            }
                            break;
                        case 3:
                            if (now == 1 || now == 3 || now == 4 || now == 5) {
                                if (next == 1 || next == 3 || next == 6 || next == 7) {
                                    queue.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    answer++;
                                }
                            }
                            break;
                    }
                }
            }
        }
    }
}
