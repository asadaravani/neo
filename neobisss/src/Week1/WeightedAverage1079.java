package Week1;

import java.io.IOException;
import java.util.Scanner;

public class WeightedAverage1079 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        //how many times will loop
        int n = scan.nextInt();

        for(int i=0; i<n; i++){
            //scanning three inputs
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();
            double ans = (a*2 + b*3 + c*5)/10.0;
            System.out.println(Math.round(ans*10.0) / 10.0);
        }
    }
}
