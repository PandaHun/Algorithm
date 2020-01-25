package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem1652 {

    private static int N;
    private static boolean[][] room;
    private static int[] answer = new int[2];

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = temp.charAt(j) == '.' ? true : false;
            }
        }

        for (int r = 0; r < N; r++) {
            boolean flag = true;
            for (int c = 0; c < N - 1; c++) {
                if (room[r][c] && room[r][c + 1]) {
                    if (!flag) continue;
                    answer[0]++;
                    flag = false;
                }
                if (!room[r][c]) flag = true;
            }
        }
        for (int r = 0; r < N; r++) {
            boolean flag = true;
            for (int c = 0; c
                    < N - 1; c++) {
                if (room[c][r] && room[c + 1][r]) {
                    if (!flag) continue;
                    answer[1]++;
                    flag = false;
                }
                if (!room[c][r]) flag = true;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
