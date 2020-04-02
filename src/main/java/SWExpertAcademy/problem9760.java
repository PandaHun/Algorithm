package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem9760 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            bw.write("#" + tc + " ");
            String answer = "High card";
            st = new StringTokenizer(br.readLine(), " ");
            int[] shape = new int[4];
            int[] num = new int[14];
            boolean straight = false;
            boolean flush = false;
            int pairCnt = 0;
            boolean three = false;
            boolean four = false;
            for (int i = 0; i < 5; i++) {
                String str = st.nextToken();
                switch (str.charAt(0)) {
                    case 'S':
                        shape[0]++;
                        break;
                    case 'D':
                        shape[1]++;
                        break;
                    case 'H':
                        shape[2]++;
                        break;
                    case 'C':
                        shape[3]++;
                        break;
                }
                switch (str.charAt(1)) {
                    case 'A':
                        num[1]++;
                        break;
                    case 'T':
                        num[10]++;
                        break;
                    case 'J':
                        num[11]++;
                        break;
                    case 'Q':
                        num[12]++;
                        break;
                    case 'K':
                        num[13]++;
                        break;
                    default:
                        num[Integer.parseInt(str.charAt(1) + "")]++;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (shape[i] == 5) {
                    straight = true;
                }
            }
            int numbers = 0;
            for (int i = 1; i <= 13; i++) {
                if (numbers > 0 && num[i] == 0) {
                    numbers--;
                } else if (num[i] == 1) {
                    numbers++;
                }
                if (i == 13 && num[1] == 1) {
                    numbers++;
                }
                if (numbers == 5) {
                    flush = true;
                }
                switch (num[i]) {
                    case 2:
                        pairCnt++;
                        break;
                    case 3:
                        three= true;
                        break;
                    case 4:
                        four = true;
                        break;
                }
            }
            if (straight) {
                if (flush) {
                    answer = "Straight Flush";
                } else {
                    answer = "Flush";
                }
            } else if (flush) {
                answer = "Straight";
            } else if (four) {
                answer = "Four of a Kind";
            } else if (three) {
                if (pairCnt > 0) {
                    answer = "Full House";
                } else {
                    answer = "Three of a kind";
                }
            } else if (pairCnt > 0) {
                if (pairCnt == 1) {
                    answer = "One pair";
                } else {
                    answer = "Two pair";
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}