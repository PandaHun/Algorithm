package SWExpertAcademy;

import java.io.*;

public class problem6782 {

    static final int FIND = 2;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            bw.write("#" + tc + " ");
            long N = Long.parseLong(br.readLine());
            long count = 0;
            while (N != FIND) {
                double t = Math.sqrt(N);
                if (t == (int) t) {
                    N = (long) t;
                } else {
                    t = (int) t;
                    count += ((t + 1) * (t + 1) - N);
                    N = (long) Math.sqrt((t + 1) * (t + 1));
                }
                count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
