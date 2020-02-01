package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1238 {

    private static final int NUNMBER = 101;

    private static List<Integer>[] contacts;
    private static boolean[] receved;
    private static int N;
    private static int start;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            contacts = new LinkedList[N];
            for(int i = 0; i < N ; i++) {
                contacts[i] = new LinkedList<>();
            }
            receved = new boolean[N];
            receved[start] = true;
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (!contacts[from].contains(to)) {
                    contacts[from].add(to);
                }
            }
            int answer = solve(start);
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    private static int solve(int index) {
        int nowNode = -1;
        int lastTime = -1;
        Queue<int[]> call = new LinkedList<>();
        call.add(new int[]{index, 0});
        while (!call.isEmpty()) {
            int now = call.peek()[0];
            int time = call.peek()[1];
            call.poll();
            if (lastTime == time && nowNode < now) {
                nowNode = now;
            } else if (lastTime < time) {
                lastTime = time;
                nowNode = now;
            }
            for (int i = 0; i < contacts[now].size(); i++) {
                int next = contacts[now].get(i);
                if (!receved[next]) {
                    receved[next] = true;
                    call.offer(new int[]{next, time + 1});
                }
            }
        }
        return nowNode;
    }
}
