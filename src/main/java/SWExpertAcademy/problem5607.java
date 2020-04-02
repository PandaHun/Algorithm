package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem5607 {

    static long[] pac;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            bw.write("#" + tc + " ");
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            pac = new long[N + 1];
            pac[0] = 1;
            for (int i = 1; i <= N; i++) {
                pac[i] = (pac[i - 1] * i) % M;
            }
            long t = (pac[R] * pac[N - R]) % M;
            long a = fermat(t, M - 2);
            bw.write((a * pac[N]) % M + "\n");
        }
        bw.flush();
    }

    static long fermat(long a, int p) {
        if (p == 0) {
            return 1;
        }
        long t = fermat(a, p / 2);
        long ret = (t * t) % M;
        if (p % 2 == 0) {
            return ret;
        } else {
            return (ret * a) % M;
        }
    }
}
