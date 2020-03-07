package Baekjoon;

import java.io.*;

public class problme1019 {

    static int start, digit, end;
    static int[] cnt;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        end = Integer.parseInt(br.readLine());
        start = 1;
        digit = 1;
        cnt = new int[10];
        while (start <= end) {

            while (start % 10 != 0 && start <= end) {
                count(start, digit);
                start++;
            }
            while (end % 10 != 9 && start <= end) {
                count(end, digit);
                end--;
            }
            if (start > end) {
                break;
            }
            start /= 10;
            end /= 10;
            for(int i = 0 ; i < 10 ; ++i) {
                cnt[i] += (end - start + 1) * digit;
            }
            digit *= 10;
        }
        for(int i : cnt) {
            bw.write(i +" ");
        }
        bw.flush();
    }

    private static void count(int num, int digit) {
        while (num > 0) {
            cnt[num % 10] += digit;
            num /= 10;
        }
    }
}
