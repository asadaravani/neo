package Week1;

import java.io.IOException;
import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++){
            int years = 0;
            int pa = scan.nextInt();
            int pb = scan.nextInt();
            double g1 = scan.nextDouble();
            double g2 = scan.nextDouble();
            while(pa <=pb){
                pa = (int) (pa+((pa*g1) / 100));
                pb = (int) (pb+((pb*g2) / 100));
                years++;
                if(years > 100){
                    break;
                }
            }
            if(years > 100){
                System.out.println("Mais de 1 seculo.");
            }
            else{
                System.out.println(years+" anos.");
            }
        }

    }
}
