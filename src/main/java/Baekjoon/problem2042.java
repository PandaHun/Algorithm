package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem2042 {

    static long[] arr, tree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N * 4];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1, 0, N - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int q = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            long y = Long.parseLong(st.nextToken());
            if (q == 1) {
                long dif = y - arr[x];
                arr[x] = y;
                update(1, x, dif, 0, N - 1);
            } else if (q == 2) {
                System.out.println(sum(1, x, (int) y - 1, 0, N - 1));
            }
        }
    }

    static long sum(int node, int left, int right, int start, int end) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(node * 2, left, right, start, (start + end) / 2) + sum(node * 2 + 1, left, right, (start + end) / 2 + 1, end);
    }

    static void update(int node, int x, long diff, int start, int end) {
        if (x < start || x > end) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            update(node * 2, x, diff, start, (start + end) / 2);
            update(node * 2 + 1, x, diff, (start + end) / 2 + 1, end);
        }
    }

    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        return tree[node] = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
    }
}
