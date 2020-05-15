package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1941 {

    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer;
    static boolean[][] visited;
    static boolean[] used;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visited = new boolean[5][5];
        used = new boolean[1 << 25];
        for (int i = 0; i < map.length; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                visited[r][c] = true;
                if (map[r][c] == 'S') {
                    solve(1, 1, (1 << (r * 5 + c)));
                } else {
                    solve(1, 0, (1 << (r * 5 + c)));
                }
                visited[r][c] = false;
            }
        }
        System.out.println(answer);
    }

    static void solve(int cnt, int s, int checked) {
        if (cnt > 7 || used[checked]) {
            return;
        }
        used[checked] = true;
        if (cnt == 7 && s >= 4) {
            answer++;
            return;
        }
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (visited[r][c]) {

                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc] || (checked & (1 << (nr * 5 + nc))) > 0) {
                            continue;
                        }
                        visited[nr][nc] = true;
                        if (map[nr][nc] == 'S') {
                            solve(cnt+1, s+1, checked | ( 1 << (nr*5 + nc)));
                        } else {
                            solve(cnt+1, s, checked | ( 1 << (nr*5 + nc)));
                        }
                        visited[nr][nc] = false;
                    }
                }
            }
        }
    }
}
