package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem2458 {

    static int[][] map;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        for (int i = 1; i <= N; i++) {
            solve(i);
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < N + 1; j++) {
                cnt += map[i][j] + map[j][i];
            }
            if (cnt == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void solve(int v) {
        if (map[v][0] == -1) {
            return;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[v][i] == 1) {
                solve(i);
                for (int j = 1; j < map.length; j++) {
                    map[v][j] |= map[i][j];
                }
            }
        }
        map[v][0] = -1;
    }
}
