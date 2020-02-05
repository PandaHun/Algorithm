package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2042 {

    private static int N;//총 숫자의 갯수
    private static int M;//총 수의 변화가 일어나는 갯수
    private static int K;//수의 합을 구하는 갯수
    private static long[] input;
    private static long[] tree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new long[N];
        tree = new long[N * 4];
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(br.readLine());
        }
        init(1, 0, N - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long diff = c - input[--b];
                input[b] = c;
                update(1, 0, N - 1, b, diff);
            } else if (a == 2) {
                sb.append(sum(1, 0, N - 1, b - 1, c - 1) + "\n");
            }
        }
        System.out.println(sb);
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(node * 2, start, (start + end) / 2, left, right) + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int b, long diff) {
        if (b < start || b > end) {
            return;
        }
        tree[node] = tree[node] + diff;
        if (start != end) {
            update(node * 2, start, (start + end) / 2, b, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, b, diff);
        }
    }

    private static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = input[start];
        } else {
            return tree[node] = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
        }
    }
}
