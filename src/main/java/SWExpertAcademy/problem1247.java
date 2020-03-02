package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem1247 {

    private static int N;
    private static int[][] customers;
    private static int[] home, orders, goal;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            customers = new int[N][2];
            home = new int[2];
            goal = new int[2];
            visited = new boolean[N];
            orders = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            solve(0);
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    private static void solve(int depth) {
        if (depth == N) {
            int temp = getDistance();
            answer = Math.min(answer, temp);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orders[depth] = i;
                solve(depth + 1);
                visited[i] = false;
                orders[depth] = 0;
            }
        }
    }

    private static int getDistance() {
        int ret = 0;
        ret += (Math.abs(home[0] - customers[orders[0]][0]) + Math.abs(home[1] - customers[orders[0]][1]));
        for (int i = 0; i < N-1; i++) {
            int cur = orders[i];
            int next = orders[i+1];
            ret += (Math.abs(customers[cur][0] - customers[next][0]) + Math.abs(customers[cur][1] - customers[next][1]));
        }
        ret += Math.abs(goal[0] - customers[orders[N-1]][0]) + Math.abs(goal[1] - customers[orders[N-1]][1]);
        return ret;
    }
}