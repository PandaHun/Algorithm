package SWExpertAcademy;

import java.io.*;
public class problem1215 {

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc=1;tc<=10;tc++){
            int answer = 0;
            int num = Integer.parseInt(br.readLine());
            String[] matrix = new String[8];
            for(int i=0;i<8;i++){
                matrix[i] = br.readLine();
            }
            for(int i=0;i<8;i++){
                for(int j=0;j<8-num+1;j++) {
                    boolean check = true;
                    for( int k=0;k<num/2;k++){
                        if( matrix[i].charAt(j+k) != matrix[i].charAt(j+num-k-1))
                            check = false;
                    }
                    if( check)
                        answer++;
                    check = true;
                    for( int k=0;k<num/2;k++){
                        if(matrix[j+k].charAt(i) != matrix[j+num-k-1].charAt(i))
                            check = false;
                    }
                    if( check)
                        answer++;
                }
            }

            System.out.println("#" +tc+" "+ answer);
        }
    }
}
