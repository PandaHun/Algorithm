package SWExpertAcademy;

import java.io.*;
public class problem1213 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc=1;tc<=10;tc++){
            int answer = 0;
            br.readLine();
            String query = br.readLine();
            String sentence = br.readLine();

            while(sentence.contains(query)){
                int temp = sentence.indexOf(query);
                sentence = sentence.substring(temp+1);
                answer++;
            }
            System.out.println("#" +tc+" "+answer);
        }
    }
}
