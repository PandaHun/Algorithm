package SWExpertAcademy;

import java.io.*;
public class problem1216 {

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc=1;tc<=10;tc++){
            int answer = 1;
            br.readLine();
            String[] matrix = new String[100];
            for(int i=0;i<100;i++){
                matrix[i] = br.readLine();
            }

            for(int num=100;num>1;num--){
                if( answer>1)
                    break;
                for(int i=0;i<100;i++){
                    for(int j=0;j<100-num+1;j++){
                        boolean check = true;
                        for( int k=0;k<num/2;k++){
                            if( matrix[i].charAt(j+k) != matrix[i].charAt(j+num-k-1))
                                check = false;
                        }
                        if( check)
                            answer = num;
                        check = true;
                        for( int k=0;k<num/2;k++){
                            if(matrix[j+k].charAt(i) != matrix[j+num-k-1].charAt(i))
                                check = false;
                        }
                        if( check)
                            answer = num;
                    }
                }
            }
            System.out.println("#" +tc+" "+ answer);
        }
    }
}
