package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1766 {

    static int M, N;
    static ArrayList<Integer>[] orders;
    static int[] degree;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        orders = new ArrayList[M + 1];
        degree = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            orders[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            orders[a].add(b);
            degree[b]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < M + 1; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");
            for(int i = 0 ; i < orders[cur].size(); i++) {
                int next = orders[cur].get(i);
                degree[next]--;
                if(degree[next]==0){
                    q.add(next);
                }
            }
        }
        bw.newLine();
        bw.flush();
    }
}
