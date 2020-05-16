package Baekjoon;

import java.util.Scanner;

public class problem1484 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int G = sc.nextInt();
        boolean flag = true;
        int s, e;
        s = e = 1;
        long d = 0;
        while (true) {
            long minus = (long) (Math.pow(e, 2)) - (long) (Math.pow(s, 2));
            if (e - s == 1 && minus > G) {
                break;
            }
            if (minus >= G) {
                s++;
            } else {
                e++;
            }
            if (minus == G) {
                sb.append(e + "\n");
                flag = false;
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}
