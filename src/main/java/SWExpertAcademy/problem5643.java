package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem5643 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
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
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    static void solve(int v) {
        if (map[v][0] == -1) {
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (map[v][i] == 1) {
                solve(i);
                for (int j = 1; j < N + 1; j++) {
                    map[v][j] |= map[i][j];
                }
            }
        }
        map[v][0] = -1;
    }
}
