package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1043 {

    private static int N, M, answer;
    private static List<Integer>[] party, people;
    private static List<Integer> know;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[M + 1];
        answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int number = Integer.parseInt(st.nextToken());
        if (number == 0) {
            System.out.println(M);
            return;
        }
        know = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }
        party = new ArrayList[M + 1];
        for (int i = 0; i < M + 1; i++) {
            party[i] = new ArrayList<>();
        }

        people = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            people[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int val = Integer.parseInt(st.nextToken());
                party[i].add(val);
                people[val].add(i);
            }
        }
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < know.size(); i++) {
            for (int j = 0; j < people[know.get(i)].size(); j++) {
                if (!visited[people[know.get(i)].get(j)]) {
                    visited[people[know.get(i)].get(j)] = true;
                    queue.add(people[know.get(i)].get(j));
                }
            }
        }
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i = 0; i < party[val].size(); i++) {
                for (int j = 0; j < people[party[val].get(i)].size(); j++) {
                    if (!visited[people[party[val].get(i)].get(j)]) {
                        visited[people[party[val].get(i)].get(j)] = true;
                        queue.add(people[party[val].get(i)].get(j));
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                answer++;
            }
        }
    }
}