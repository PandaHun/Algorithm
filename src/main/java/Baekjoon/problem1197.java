package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem1197 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge>[] lists = new ArrayList[N];
        int[] direction = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
            direction[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            lists[start].add(new Edge(end, value));
            lists[end].add(new Edge(start, value));
        }

        int start = 0;
        visited[start] = true;
        direction[start] = 0;
        int answer = 0;
        while (true) {
            for (int i = 0; i < lists[start].size(); i++) {
                int target = lists[start].get(i).end;
                int value = lists[start].get(i).value;

                if (!visited[target] && direction[target] > value) {
                    direction[target] = value;
                }
            }
            int min = Integer.MAX_VALUE;
            boolean isEnd = true;
            for (int i = 0; i < N; i++) {
                if( visited[i] || direction[i] == Integer.MAX_VALUE) {
                    continue;
                }
                if(direction[i] < min) {
                    min = direction[i];
                    start = i;
                    isEnd = false;
                }
            }
            if(isEnd) {
                break;
            }
            visited[start] = true;
            answer += min;
        }
        System.out.println(answer);
    }
}

class Edge {

    int end;
    int value;

    public Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
}