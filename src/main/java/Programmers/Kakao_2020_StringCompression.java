package Programmers;

public class Kakao_2020_StringCompression {

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            String compress = "";
            String target = "";
            String current = "";
            int cnt = 1;
            for(int k = 0 ; k < i ; k++) {
                target += s.charAt(k);
            }
            for (int k = i; k < len; k += i) {
                current = "";
                for (int j = k; j < k + i; j++) {
                    if (j >= len) {
                        break;
                    }
                    current += s.charAt(j);
                }

                if (target.equals(current)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        compress += cnt + target;
                    } else {
                        compress += target;
                    }
                    cnt = 1;
                    target = current;
                }
            }

            if (cnt > 1) {
                compress += cnt + target;
            } else {
                compress += target;
            }
            int length = compress.length();
            answer = answer > length ? length : answer;
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 1;
        }
        return answer;
    }
}
