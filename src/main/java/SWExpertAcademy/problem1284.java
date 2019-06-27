import java.util.Scanner;

public class problem1284{
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
      /*Test Case Variable*/
    	int t = sc.nextInt();
      /*Input Variable Array*/
      int[][] va =  new int [t][7];
      //Get the input Value
      for(int i =0;i<t;i++){
        int temp = 0;
        for(int j=0;j<5;j++){
          va[i][j] = sc.nextInt();
          if(j==4){
            temp = va[i][j];
          }
        }
        //Using A
        va[i][5] =  temp*va[i][0];
        //Using B
        va[i][6] = va[i][1];
        if( temp > va[i][2]){
          va[i][6]  += (temp-va[i][2])*va[i][3];
        }
      }
      //output
      for(int i = 1; i<=t; i++){
        System.out.print("#" + i);
        if(va[i-1][5]> va[i-1][6])
          System.out.println(" "+va[i-1][6]);
        else
          System.out.println(" "+va[i-1][5]);
      }
    }
  }
