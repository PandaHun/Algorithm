import java.util.Scanner;
import java.io.*;
public class problem1204{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //Test Case
        int[][] input = new int[T][101];
        //init the array
        for(int i=0;i<T;i++)
            for(int j=0;j<101;j++){
                input[i][j]=0;
            }
        //get the Input data
        for(int i = 0;i<T;i++){
            sc.nextInt();
            for(int j=0;j<1000;j++){
                input[i][sc.nextInt()]++;
            }
        }
        //logic
        for(int i=0;i<T;i++){
            int max = input[i][0];
            int index=0;
            for(int j=1;j<101;j++){
                if(max<= input[i][j]){
                    max = input[i][j];
                    index = j;
                }
            }
            System.out.print("#"+ (i+1)+" " +index+"\n");
        }
    }
}
