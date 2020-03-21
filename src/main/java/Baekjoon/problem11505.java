package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem11505 {

    static final int MOD = 1000000007;

    static int N, M, K;
    static int[] nums;
    static long[] tree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        tree = new long[2 * (1 << H)];
        initTree(1, 0, N - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int method = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (method == 1) {
                updateTree(1, 0, N - 1, b - 1, c);
                nums[b - 1] = c;
            } else {
                long result = query(1, 0, N - 1, b - 1, c - 1);
                bw.write(result + "\n");
            }
        }
        bw.close();
    }

    static long query(int idx, int s, int d, int l, int r) {
        if (r < s || l > d) {
            return -1;
        }
        if (l <= s && d <= r) {
            return tree[idx];
        }

        int m = (s + d) >> 1;
        long q1 = query(idx * 2, s, m, l, r);
        long q2 = query(idx * 2 + 1, m + 1, d, l, r);

        if (q1 == -1) {
            return q2;
        } else if (q2 == -1) {
            return q1;
        } else {
            return (q1 * q2) % MOD;
        }
    }

    static void updateTree(int idx, int s, int d, int target, int data) {
        if (s <= target && target <= d) {
            if (s == d) {
                tree[idx] = data % MOD;
            } else {
                int m = (s + d) >> 1;
                updateTree(idx * 2, s, m, target, data);
                updateTree(idx * 2 + 1, m + 1, d, target, data);
                tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % MOD;
            }
        }
    }

    static void initTree(int idx, int s, int d) {
        if (s == d) {
            tree[idx] = nums[s] % MOD;
        } else {
            int m = (s + d) >> 1;
            initTree(idx * 2, s, m);
            initTree(idx * 2 + 1, m + 1, d);

            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % MOD;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
