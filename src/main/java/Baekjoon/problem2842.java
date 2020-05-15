package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2842 {

    static int[][] value;
    static char[][] map;
    static int[] start;
    static List<Integer> list;
    static int number;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        value = new int[N][N];
        map = new char[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'P') {
                    start = new int[2];
                    start[0] = i;
                    start[1] = j;
                }
                if (map[i][j] == 'K') {
                    number++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
                if (!list.contains(value[i][j])) {
                    list.add(value[i][j]);
                }
            }
        }
        Collections.sort(list);
        System.out.println(solve());
    }

    static int solve() {
        int min, max;
        min = max = 0;
        int answer = Integer.MAX_VALUE;
        int len = list.size();
        while (min < len && max < len) {
            if (check(list.get(min), list.get(max))) {
                int t = list.get(max) - list.get(min);
                answer = Math.min(answer, t);
                min++;
            } else {
                max++;
            }
        }
        return answer;
    }

    static boolean check(int min, int max) {
        int h = value[start[0]][start[1]];
        if (h < min || h > max) {
            return false;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int cnt = 0;
        boolean[][] visited = new boolean[map.length][map.length];
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (map[now[0]][now[1]] == 'K') {
                cnt++;
            }
            if (cnt == number) {
                return true;
            }
            for (int k = 0; k < 8; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if (nr < 0 || nc < 0 || nr >= visited.length || nc >= visited.length || visited[nr][nc]) {
                    continue;
                }
                if (value[nr][nc] >= min && value[nr][nc] <= max) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
