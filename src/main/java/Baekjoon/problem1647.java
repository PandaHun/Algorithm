package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class problem1647 {

    static int N, M;
    static int[] parents;
    static int[][] roads;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        roads = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(roads, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            if (find(x) != find(y)) {
                answer += roads[i][2];
                cnt++;
                union(x, y);
            }
            if (cnt == N - 2) {
                break;
            }
        }
        System.out.println(answer);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            parents[b] = a;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
