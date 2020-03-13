package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem9205 {

    private static int[][] position;
    private static int N;
    private static boolean isAble;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            N = Integer.parseInt(br.readLine());
            position = new int[N + 2][2];
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                position[i][0] = Integer.parseInt(st.nextToken());
                position[i][1] = Integer.parseInt(st.nextToken());
            }
            isAble = false;
            int[] start = position[0];
            int[] end = position[N + 1];
            Queue<int[]> q = new LinkedList<>();
            boolean[] visted = new boolean[N + 2];
            q.add(start);
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (now[0] == end[0] && now[1] == end[1]) {
                    isAble = true;
                    break;
                }
                for (int i = 1; i < N + 2; i++) {
                    if (!visted[i] && Math.abs(now[0] - position[i][0]) + Math.abs(now[1] - position[i][1]) <= 1000) {
                        q.add(position[i]);
                        visted[i] = true;
                    }
                }
            }
            if (isAble) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }
        bw.flush();
    }
}
