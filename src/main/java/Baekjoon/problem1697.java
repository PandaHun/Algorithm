package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 숨바꼭질
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1697 {

    private static int start, end;
    private static int[] visit;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        visit = new int[100001];

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        if (start >= end){
            System.out.println(start-end);
            return;
        }

        System.out.println(solve()-1);

    }

    static int solve() {
        visit[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        int[] nexts = new int[3];

        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end)
                return visit[now];
            nexts[0] = now - 1;
            nexts[1] = now + 1;
            nexts[2] = now * 2;
            for (int i = 0; i < 3; i++) {
                if (nexts[i] < 100001 && nexts[i] >= 0){

                    if (visit[nexts[i]] == 0) {
                        queue.add(nexts[i]);
                        visit[nexts[i]] = visit[now] + 1;
                    }
                }
            }
        }

        return 0;
    }
}
