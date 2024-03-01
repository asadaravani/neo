package Week1;

import java.io.IOException;
import java.util.Scanner;

public class ColumnArray1182 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        scan.nextLine();
        char operation = scan.nextLine().charAt(0);
        double[][] array = new double[12][12];
        for(int i=0; i<12; i++){
            for(int j=0; j<12; j++){
                array[i][j] = scan.nextDouble();
            }
        }
        double sum  = 0;
        for(int i=0; i<12; i++){
            for(int j=0; j<12; j++){
                if(j == c){
                    sum+=array[i][j];
                }
            }
        }
        if(operation == 'S'){
            System.out.printf("%.1f\n", sum);
        }
        else{
            System.out.printf("%.1f\n", sum / 12);
        }
    }
}
