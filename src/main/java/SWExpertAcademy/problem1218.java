package SWExpertAcademy;

import java.io.*;
import java.util.*;
public class problem1218 {

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[11];
        for(int tc=1;tc<=10;tc++){
            int length = Integer.parseInt(br.readLine());
            char[] pair = br.readLine().toCharArray();
            Stack<Character> st = new Stack();
            answer[tc] = 1;
            for(int i=0;i<length;i++){
                char temp = pair[i];
                if( temp == '[' || temp == '{' || temp=='(' || temp =='<' ){
                    st.push(pair[i]);
                }
                if(temp ==']' || temp =='}' || temp ==')' || temp =='>'){
                    if(st.empty()){
                        answer[tc] = 0;
                        break;
                    }
                    char top = st.pop();
                    if ( (top == '[' && temp ==']')|| (top == '{'&& temp =='}') || (top=='('&& temp ==')') || (top =='<'&&temp =='>')  )
                        continue;
                    else {
                        answer[tc] = 0;
                        break;
                    }
                }
            }

            System.out.println(String.format("#%d %d", tc, answer[tc]));
        }
    }
}
