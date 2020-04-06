package SWExpertAcademy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem9659 {

    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 1];
            dp[0] = 1;
            List<Info>[] li = new List[n + 1];
            for (int i = 2; i <= n; i++) {
                li[i] = new ArrayList<>();
            }

            for (int i = 2; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int t = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                li[i].add(new Info(t, a, b));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            bw.write("#" + tc + " ");
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                dp[1] = x;
                for (int j = 2; j <= n; j++) {
                    int t = li[j].get(0).t;
                    int a = li[j].get(0).a;
                    int b = li[j].get(0).b;
                    if (t == 1) {
                        dp[j] = (dp[a] + dp[b]) % MOD;
                    } else if (t == 2) {
                        dp[j] = (a * dp[b]) % MOD;
                    } else if (t == 3) {
                        dp[j] = (dp[a] * dp[b]) % MOD;
                    }
                }
                bw.write(dp[n] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}

class Info {

    int t;
    int a;
    int b;

    public Info(int t, int a, int b) {
        this.t = t;
        this.a = a;
        this.b = b;
    }
}