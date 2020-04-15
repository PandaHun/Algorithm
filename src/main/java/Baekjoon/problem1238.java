package Baekjoon;

import java.io.*;
import java.util.*;

public class problem1238 {

    static int N, M, X;
    static int[][] towns;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        towns = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j) {
                    continue;
                }
                towns[i][j] = 1000000;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            towns[s][e] = Math.min(towns[s][e], c);
        }
        solve();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, towns[i][X] + towns[X][i]);
        }
        System.out.println(answer);
    }

    static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    towns[i][j] = Math.min(towns[i][j], towns[i][k] + towns[k][j]);
                }
            }
        }
    }
}