package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem3234 {

    static int N, answer, rights, temp;
    static int[] weights;
    static boolean[] used;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            weights = new int[N];
            used = new boolean[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }
            rights = 0;
            permutation(0);
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    static void permutation(int depth) {
        if (depth == N) {
            dfs(0, 0, 0);
            return;
        }
        for (int i = depth; i < N; i++) {
            temp = weights[depth];
            weights[depth] = weights[i];
            weights[i] = temp;
            permutation(depth + 1);
            temp = weights[depth];
            weights[depth] = weights[i];
            weights[i] = temp;
        }
    }

    static void dfs(int depth, int l, int r) {
        if (depth == N) {
            answer++;
            return;
        }
        rights = l + weights[depth];
        dfs(depth + 1, rights, r);
        rights = r + weights[depth];
        if( rights <= l) {
            dfs(depth+1, l ,rights);
        }
    }
}
