package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem7578 {

    static int h;
    static long[] tree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        HashMap<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            B.put(Integer.parseInt(st.nextToken()), i);
        }
        h = 1;
        while (h <= n) {
            h <<= 1;
        }
        tree = new long[h * 2];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = A[i];
            int b = B.get(a);
            ans += sum(1, h, h * 2 - 1, h + b - 1, h * 2 - 1);
            update(h + b - 1);
        }
        System.out.println(ans);
    }

    static void update(int idx) {
        tree[idx] += 1;
        while (idx >= 1) {
            idx >>= 1;
            tree[idx] += 1;
        }
    }

    static long sum(int node, int s, int e, int l, int r) {
        if (l > e || s > r) {
            return 0L;
        }
        if (l <= s && e <= r) {
            return tree[node];
        }
        int m = (s + e) >> 1;
        return sum(node * 2, s, m, l, r) + sum(node * 2 + 1, m + 1, e, l, r);
    }
}
