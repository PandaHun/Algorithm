package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1220 {

    private static int N;
    private static int[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for (int c = 0; c < N; c++) {
                for (int r = 0; r < N; r++) {
                    if (map[r][c] == 2) {
                        map[r][c] = 0;
                    } else if (map[r][c] == 1) {
                        break;
                    }
                }
            }
            for (int c = 0; c < N; c++) {
                for (int r = N - 1; r >= 0; r--) {
                    if (map[r][c] == 1) {
                        map[r][c] = 0;
                    } else if (map[r][c] == 2) {
                        break;
                    }
                }
            }

            for (int c = 0; c < N; c++) {
                int value = 0;
                for (int r = 0; r < N; r++) {
                    if (map[r][c] == 1) {
                        if (value == 0) {
                            value = 1;
                        }
                    } else if (map[r][c] == 2) {
                        if (value == 1) {
                            value = 0;
                            answer++;
                        }
                    }
                }
            }
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
