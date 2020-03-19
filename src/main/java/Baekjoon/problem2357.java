package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem2357 {

    static int N, M, capacity;
    static int[] max, min;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (capacity = 1; capacity < N; capacity *= 2) ;
        max = new int[capacity * 2];
        min = new int[capacity * 2];
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            max[capacity + i] = number;
            min[capacity + i] = number;
        }
        makeMaxTree();
        makeMinTree();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int maxValue = maxQuery(s, d, 1, 1, capacity - 1);
            int minValue = minQuery(s, d, 1, 1, capacity - 1);
            bw.write(minValue + " " + maxValue);
            bw.newLine();
        }
        bw.close();
    }

    static int maxQuery(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) {
            return Integer.MIN_VALUE;
        }
        if (L <= temp_L && temp_R <= R) {
            return max[idx];
        }
        int mid = (temp_L + temp_R) / 2;

        return Math.max(maxQuery(L, R, idx * 2, temp_L, mid), maxQuery(L, R, idx * 2 + 1, mid + 1, temp_R));
    }

    public static int minQuery(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) {
            return Integer.MAX_VALUE;
        }
        if (L <= temp_L && temp_R <= R) {
            return min[idx];
        }
        int mid = (temp_L + temp_R) / 2;

        return Math.min(minQuery(L, R, idx * 2, temp_L, mid), minQuery(L, R, idx * 2 + 1, mid + 1, temp_R));
    }

    static void makeMaxTree() {
        for (int i = capacity - 1; i > 0; i--) {
            max[i] = Math.max(max[i * 2], max[i * 2 + 1]);
        }
    }

    static void makeMinTree() {
        for (int i = capacity - 1; i > 0; i--) {
            min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
        }
    }
}
