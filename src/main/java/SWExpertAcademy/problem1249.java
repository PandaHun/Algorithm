package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class problem1249 {

    private static int N;
    private static int[][] map;
    private static int[][] time;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            time = new int[N][N];
            for (int r = 0; r < N; r++) {
                String temp = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = temp.charAt(c) - '0';
                }
                Arrays.fill(time[r], Integer.MAX_VALUE / 2);
            }
            solve();
            sb.append("#" + tc + " " + time[N - 1][N - 1] + "\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int r = now.r;
            int c = now.c;
            int cost = now.cost;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (outOfRange(nr, nc)) {
                    continue;
                }
                int nextCost = cost + map[nr][nc];
                if (time[nr][nc] > nextCost) {
                    time[nr][nc] = nextCost;
                    queue.offer(new Node(nr, nc, nextCost));
                }
            }
        }
    }

    private static boolean outOfRange(int r, int c) {
        return (r < 0 || r >= N || c < 0 || c >= N);
    }
}

class Node {
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}
