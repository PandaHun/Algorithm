package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 집합의 표현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1717 {

    private static int N, M;
    private static int[] parents;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int operation = Integer.parseInt(st.nextToken());
            int matrixA = Integer.parseInt(st.nextToken());
            int matrixB = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                Union(matrixA, matrixB);
            } else if (operation == 1) {
                int p1 = Find(matrixA);
                int p2 = Find(matrixB);

                if (p1 == p2) {
                    sb.append("YES").append("\n");
                } else
                    sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static int Find( int a ) {
        if (parents[a] == a)
            return a;

        return parents[a] = Find(parents[a]);
    }

    static void Union( int a, int b ) {
        int p = Find(a);
        int q = Find(b);
        if (p == q) return;
        parents[q] = p;
    }

}
