package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class problem1211 {

    private static int N;
    private static int[] distance;
    private static int[][] ladders;
    private static int[] dr = {0, 0, 1};
    private static int[] dc = {-1, 1, 0};
    private static List<Integer> starters;
    private static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int min = Integer.MAX_VALUE;
            int answer = 0;
            sc.nextInt();
            ladders = new int[100][100];
            starters = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ladders[i][j] = sc.nextInt();
                    if (i == 0 & ladders[i][j] == 1) {
                        starters.add(j);
                    }
                }
            }
            N = starters.size();
            distance = new int[N];

            for (int i = 0; i < N; i++) {
                visited = new boolean[100][100];
                distance[i] = solve(starters.get(i));
                min = Math.min(distance[i], min);
            }
            for (int i = N - 1; i >= 0; i--) {
                if (distance[i] == min) {
                    answer = starters.get(i);
                    break;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int start) {
        int r = 0;
        int c = start;
        int distance = 0;
        visited[r][c] = true;
        while (r < 99) {

            for (int k = 0; k < 3; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (outOfBounds(nr, nc)) continue;

                if (!visited[nr][nc] && ladders[nr][nc] == 1) {
                    distance++;
                    visited[nr][nc] = true;
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }
        return distance;
    }

    private static boolean outOfBounds(int nr, int nc) {
        return (nr < 0 || nr >= 100 || nc < 0 || nc >= 100);
    }
}
