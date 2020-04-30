package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem6109 {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static String query;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            bw.write("#" + tc + "\n");
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            query = st.nextToken();
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int d = 0;
            switch (query) {
                case "up":
                    d = 1;
                    break;
                case "down":
                    d = 0;
                    break;
                case "right":
                    d = 3;
                    break;
                case "left":
                    d = 2;
                    break;
            }
            lean(d);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    bw.write(board[r][c] + " ");
                }
                bw.newLine();
            }
        }
        bw.flush();
    }

    static void lean(int dir) {
        visited = new boolean[N][N];

        if (dir == 0) {
            for (int r = N - 1; r >= 0; r--) {
                for (int c = 0; c < N; c++) {
                    doLean(r, c, dir);
                }
            }
        } else if (dir == 1) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    doLean(r, c, dir);
                }
            }
        } else if (dir == 2) {
            for (int c = 0; c < N; c++) {
                for (int r = 0; r < N; r++) {
                    doLean(r, c, dir);
                }
            }
        } else if (dir == 3) {
            for (int c = N - 1; c >= 0; c--) {
                for (int r = 0; r < N; r++) {
                    doLean(r, c, dir);
                }
            }
        }
    }

    private static void doLean(int r, int c, int dir) {
        if (board[r][c] == 0) {
            return;
        }
        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                return;
            }
            if (visited[nr][nc]) {
                return;
            }
            if (board[nr][nc] == board[r][c]) {
                visited[nr][nc] = true;
                board[nr][nc] *= 2;
                board[r][c] = 0;
                return;
            } else if (board[nr][nc] != 0) {
                return;
            }
            board[nr][nc] = board[r][c];
            board[r][c] = 0;
            r = nr;
            c = nc;
        }
    }
}
