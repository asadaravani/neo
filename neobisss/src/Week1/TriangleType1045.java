package Week1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TriangleType1045 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        triangleType(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());

    }
    public static void triangleType(double ad, double bd, double cd){
        double a, b ,c;
        double[] arr = new double[3];
        arr[0] = ad; arr[1] = bd; arr[2] = cd;
        Arrays.sort(arr);
        a = arr[2]; b = arr[1]; c = arr[0];
        if(a==b+c || a>b+c){
            System.out.println("NAO FORMA TRIANGULO");
        }
        else if(a*a ==b*b  + c*c){
            System.out.println("TRIANGULO RETANGULO");
        }
        else if(a*a> b*b + c*c){
            System.out.println("TRIANGULO OBTUSANGULO");
        }
        else if(a*a< b*b + c*c){
            System.out.println("TRIANGULO ACUTANGULO");
        }
        else if(a==b && b==c){
            System.out.println("TRIANGULO EQUILATERO");
        }
        else if ((a==b && c<b) || (a==b && c>b) || (a==c && c>b) || (a==c && c<b) || (b==c && c>a) || (b==c && c<a)){
            System.out.println("TRIANGULO ISOSCELES");
        }
    }
}
