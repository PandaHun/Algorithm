package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem9019 {

    static final int M = 10000;

    static int s, d;
    static String[] query;
    static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            query = new String[10000];
            Arrays.fill(query, "");
            visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();
            visited[s] = true;
            queue.add(s);
            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now == d) {
                    bw.write(query[d] + "\n");
                    break;
                }

                int next = (now * 2) % M;
                if (!visited[next]) {
                    visited[next] = true;
                    query[next] = query[now] +"D";
                    queue.offer(next);
                }
                next = now == 0 ? 9999 : now -1;
                if (!visited[next]) {
                    visited[next] = true;
                    query[next] = query[now] +"S";
                    queue.offer(next);
                }
                next = now / 1000 + (now % 1000) * 10;
                if (!visited[next]) {
                    visited[next] = true;
                    query[next] = query[now] +"L";
                    queue.offer(next);
                }
                next = (now % 10) * 1000 + now / 10;
                if (!visited[next]) {
                    visited[next] = true;
                    query[next] = query[now] +"R";
                    queue.offer(next);
                }
            }
        }
        bw.close();
        br.close();
    }
}
