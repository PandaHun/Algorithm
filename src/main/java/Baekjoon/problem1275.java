package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem1275 {

    static int N, C;
    static long[] trees, numbers;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        for (C = 1; C < N; C *= 2) ;
        trees = new long[C * 2];
        numbers = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        // 트리 초기화
        int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        trees = new long[treeSize];
        init(1, 0, N - 1);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());

            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            bw.write(query(1, 0, N - 1, x, y) + "\n");
            update(1, 0, N - 1, a, b - numbers[a]);
            numbers[a] = b;
        }
        bw.close();
    }

    public static void init(int node, int start, int end) {
        if (start == end) {
            trees[node] = numbers[start];
        } else {
            int half = (start + end) / 2;
            init(node * 2, start, half);
            init(node * 2 + 1, half + 1, end);

            trees[node] = trees[node * 2] + trees[node * 2 + 1];
        }
    }

    static void update(int node, int start, int end, int index, long diff) {

        if (!(start <= index && index <= end))
            return;
        trees[node] += diff;
        if (start != end) {
            int half = (start + end) / 2;
            update(node * 2, start, half, index, diff);
            update(node * 2 + 1, half + 1, end, index, diff);
        }
    }

    public static long query(int node, int start, int end, int i, int j) {

        if (i > end || j < start)
            return -1;

        if (i <= start && end <= j)
            return trees[node];

        int half = (start + end) / 2;
        long m1 = query(node * 2, start, half, i, j);
        long m2 = query(node * 2 + 1, half + 1, end, i, j);

        if (m1 == -1)
            return m2;
        else if (m2 == -1)
            return m1;
        else
            return m1 + m2;    // 범위 안의 값을 더해줌
    }
}
