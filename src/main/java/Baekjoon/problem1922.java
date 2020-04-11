package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class problem1922 {

    static int N, M;
    static int[][] lines;
    static int[] parents;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lines = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < 3; k++) {
                lines[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int x = lines[i][0];
            int y = lines[i][1];
            if (find(x) != find(y)) {
                answer += lines[i][2];
                union(x, y);
                cnt++;
            }
            if (cnt == N - 1) {
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
