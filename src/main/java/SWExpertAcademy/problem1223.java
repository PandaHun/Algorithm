package SWExpertAcademy;

import java.io.*;
import java.util.*;
class Stack{
    int top;
    String[] arr;
    String str;

    Stack(int len){
        top = -1;
        arr = new String[len];
        str = "";
    }
    void push(String item){
        top++;
        arr[top] = item;
    }
    String pop(){
        String tmp =  arr[top];
        top --;
        return tmp;
    }
    String get(){
        return arr[top];
    }
    boolean isEmpty(){
        if (top == -1)
            return true;
        return false;
    }
    String print(){
        for(int i=0;i<=top;i++){
            str +=arr[i];
        }
        return str;
    }

}
public class problem1223 {
    public static void main(String[] args)throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1;tc<=10;tc++){
            int strLen = Integer.parseInt(br.readLine());
            int answer = 0;
            String inputLine = br.readLine();
            Stack st1 = new Stack(strLen);
            Stack st2 = new Stack(strLen);

            for (int i=0;i<strLen;i++){
                char tmp =  inputLine.charAt(i);
                if( tmp != '+' && tmp != '*'){
                    st2.push(tmp+"");
                }
                else{
                    if (tmp =='+'){
                        while(!st1.isEmpty()){
                            st2.push(st1.pop());
                        }
                    }
                    else{
                        while(!st1.isEmpty() && st1.get() =='*'+""){
                            st2.push(st1.pop());
                        }
                    }
                    st1.push(tmp+"");
                }
            }

            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            String post = st2.print();
            for(int i=0;i<strLen;i++){
                char tmp = post.charAt(i);
                if(tmp !='+' && tmp!='*'){
                    st1.push(tmp+"");
                }
                else{
                    int arg2 = Integer.parseInt(st1.pop());
                    int arg1 = Integer.parseInt(st1.pop());
                    if(tmp=='+'){
                        st1.push(Integer.toString(arg1+arg2));
                    }
                    else if(tmp=='*'){
                        st1.push(Integer.toString(arg1*arg2));
                    }
                }
            }
            answer = Integer.parseInt(st1.pop());
            System.out.println("#" +tc+" "+answer);
        }
    }
}
