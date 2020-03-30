package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem17071 {

    static int[] times = new int[500001];
    static boolean[][] visit = new boolean[500001][2];

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(times, -1);
        int time = 0;
        while (true) {
            K += time;
            if( K > 500000) {
                break;
            }
            times[K] = time++;
        }
        bfs(N, K);
    }

    static void bfs(int n, int k) {
        Queue<int[] > queue = new LinkedList<>();
        visit[n][0] = true;
        queue.add(new int[]{n, 0});
        int min = Integer.MAX_VALUE;
        while( !queue.isEmpty()) {
            int[] now = queue.poll();
            if( now[1] > min) {
                break;
            }
            if( times[now[0]] != -1 && times[now[0]] >= now[1]) {
                if (Math.abs(times[now[0]] - now[1]) % 2 == 0) {
                    min = Math.min(min, times[now[0]]);
                }
            }
            for (int i = 0; i < 3; i++) {
                int nx = nextNum(now[0], i);
                if (nx > 500000) {
                    break;
                }
                if (nx >= 0 && !visit[nx][now[1] % 2]) {
                    visit[nx][now[1] % 2] = true;
                    queue.add(new int[]{nx, now[1] + 1});
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : (min));
    }

    static int nextNum(int num, int dir) {
        switch (dir) {
            case 0:
                return num + 1;
            case 1:
                return num - 1;
            case 2:
                return num * 2;
        }
        return -1;
    }

}
