package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Kakao_2019_Tuple {

    public static void main(String[] args) {
        System.out.println(solution(new String("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{}");
        List<String> inputs = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if ( !t.equals(",")) {
                inputs.add(t);
            }
        }
        Collections.sort(inputs, (o1, o2)-> {
            return o1.length() - o2.length();
        });
        List<String> res = new ArrayList<>();
        for(String t : inputs) {
            String[] temp = t.split(",");
            for(int i = 0 ; i < temp.length; i++) {
                if( !res.contains(temp[i])) {
                    res.add(temp[i]);
                }
            }
        }
        int[] answer = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i++) {
            answer[i] = Integer.parseInt(res.get(i));
        }
        return answer;
    }
}
