package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem15685 {

    private static int N;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {1, 0, -1, 0};
    private static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            makeDragonCurve(r, c, d, g);
        }

        int answer = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] == 1 && map[r + 1][c] == 1 && map[r][c + 1] == 1 && map[r + 1][c + 1] == 1) {
                    answer++;
                }
            }
        }
        System.out.print(answer + "\n");
    }

    private static void makeDragonCurve(int r, int c, int direction, int generation) {
        int nr = r + dr[direction];
        int nc = c + dc[direction];
        List<Integer> dirs = new ArrayList<>();
        dirs.add(direction);
        map[r][c] = 1;

        if (nr < 0 || nc < 0 || nr >= 101 || nc >= 101) {
            return;
        }

        map[nr][nc] = 1;
        while (generation-- > 0) {
            for (int i = dirs.size() - 1; i >= 0; i--) {
                int nd = (dirs.get(i) + 1) % 4;
                nr += dr[nd];
                nc += dc[nd];

                if (nr < 0 || nc < 0 || nr >= 101 || nc >= 101) {
                    continue;
                }
                map[nr][nc] = 1;
                dirs.add(nd);
            }
        }
    }
}
