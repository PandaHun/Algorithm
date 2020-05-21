package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1062 {

    static boolean[][] spells;
    static boolean[] visit;
    static int N, K, max;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        spells = new boolean[N][26];
        String in = "";
        for (int i = 0; i < N; i++) {
            in = br.readLine();
            for (char c : in.toCharArray()) {
                spells[i][c - 'a'] = true;
            }
        }
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            K -= 5;
            visit = new boolean[26];
            visit[0] = true;
            visit['c' - 'a'] = true;
            visit['i' - 'a'] = true;
            visit['n' - 'a'] = true;
            visit['t' - 'a'] = true;
            dfs(0, 0);
        }
        System.out.println(max);
    }

    static void dfs(int v, int cnt) {
        if (cnt == K) {
            int res = 0;
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                flag = true;
                for (int k = 0; k < 26; k++) {
                    if (!visit[k] & spells[i][k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
            max = Math.max(max, res);
        }

        for (int i = v; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
