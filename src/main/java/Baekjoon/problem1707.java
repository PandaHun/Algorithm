package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1707 {

    static int V, E;
    static ArrayList<ArrayList<Integer>> graph; // 정점의 갯수와 간선의 갯수가 많기 때문에 2차원 리스트로 구현한다.
    static int[] selected;   // 첫 boolean으로 하려 했지만, 방문여부와 집합을 구분을 위해 int

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            selected = new int[V + 1];
            for (int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                //양방향으로 가능하기 때문에
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            //selected 0 은 미방문 1, -1 로 집합을 구분
            for (int i = 1; i < V + 1; i++) {
                if (selected[i] == 0) {
                    selected[i] = 1;
                    solve(i);
                }
            }
            bw.write(check() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    static String check() {
        for(int n = 1; n < V + 1; n++) {
            for(int m = 0 ; m < graph.get(n).size(); m++) {
                //만약 연결된 정점이 같은 집합이라면 No
                if( selected[n] == selected[graph.get(n).get(m)]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    //bfs
    static void solve(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph.get(node)) {
                //연결된 node에 미방문
                if( selected[i] == 0) {
                    //탐색할 내가 1 집합이면 -1, -1 집합이면 1로 구분
                    if( selected[node] == 1) {
                        selected[i] = -1;
                    } else if( selected[node] == -1) {
                        selected[i] = 1;
                    }
                    queue.add(i);
                }
            }
        }
    }
}