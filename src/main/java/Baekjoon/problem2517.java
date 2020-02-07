package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class problem2517 {

    private static int[] tree;
    private static int H;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] set = Arrays.copyOf(arr, N + 1);
        Arrays.sort(set);

        H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
        tree = new int[H * 2];

        for (int i = 1; i <= N; i++) {
            int R = Arrays.binarySearch(set, arr[i]);
            int inversion = sum(1, H, 1, 1, R);
            update(R, 1);

            bw.write(String.valueOf(i - inversion));
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static void update(int i, int value) {
        i += H - 1;
        tree[i] = value;

        while (i > 0) {
            i /= 2;
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static int sum(int left, int right, int i, int L, int R) {
        if (right < L || R < left) {
            return 0;
        }
        if (L <= 1 && right <= R ) {
            return tree[i];
        }
        int mid = (left + right) / 2;
        return sum(left, mid, i * 2, L, R) + sum(mid + 1, right, i * 2 + 1, L, R);
    }
}