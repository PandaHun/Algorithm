package Programmers;

public class Kakao_2018_DartGame {

    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int len = dartResult.length();
        int[] answer = new int[3];
        int cnt, idx;
        cnt = idx = 0;
        for (int i = 0; i < len; i++) {
            char c = dartResult.charAt(i);
            int temp = 0;
            if (Character.isDigit(c)) {
                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    i++;
                    temp = Integer.parseInt(c + "" + dartResult.charAt(i));
                } else {
                    temp = c - '0';
                }
                answer[idx] = temp;
                cnt++;
            } else {
                switch (c) {
                    case 'D':
                        answer[idx] = (int) Math.pow(answer[idx], 2);
                        idx++;
                        break;
                    case 'S':
                        idx++;
                        break;
                    case 'T':
                        answer[idx] = (int) Math.pow(answer[idx], 3);
                        idx++;
                        break;
                    case '*':
                        idx = Math.max(idx - 2, 0);
                        while (idx < cnt) {
                            answer[idx] = answer[idx] * 2;
                            idx++;
                        }
                        break;
                    case '#':
                        answer[idx - 1] = answer[idx - 1] * (-1);
                        break;
                }
            }
        }
        int ret = 0;
        for (int t : answer) {
            ret += t;
        }
        return ret;
    }
}
