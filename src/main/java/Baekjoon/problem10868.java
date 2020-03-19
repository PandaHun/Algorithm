package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem10868 {

    static int N, M, capacity;
    static int[] min;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (capacity = 1; capacity < N; capacity *= 2) ;
        min = new int[capacity * 2];
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            min[capacity + i] = number;
        }
        makeMinTree();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int minValue = minQuery(s, d, 1, 1, capacity - 1);
            bw.write(minValue+"");
            bw.newLine();
        }
        bw.close();
    }

    public static int minQuery(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) return Integer.MAX_VALUE;
        if (L <= temp_L && temp_R <= R) return min[idx];
        int mid = (temp_L + temp_R) / 2;

        return Math.min(minQuery(L, R, idx * 2, temp_L, mid), minQuery(L, R, idx * 2 + 1, mid + 1, temp_R));
    }

    static void makeMinTree() {
        for (int i = capacity - 1; i > 0; i--) {
            min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
        }
    }
}
