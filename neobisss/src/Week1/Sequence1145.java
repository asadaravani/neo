package Week1;

import java.io.IOException;
import java.util.Scanner;

public class Sequence1145 {
    public static void main(String[] args) throws IOException {
        ///Accepted!!!
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        for(int i =1, j=1; i<=y; i++, j++){
            System.out.print(i);
            if(j == x){
                System.out.print("\n");
                j =0;
            }
            else{
                System.out.print(" ");

            }
        }
    }
}
