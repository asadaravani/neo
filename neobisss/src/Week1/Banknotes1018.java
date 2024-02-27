package Week1;

import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Banknotes1018 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int input  = scan.nextInt();
        int[] arr = {100,50,20,10,5,2,1};
        int[] ans = new int[7];
        for(int i=0; i<ans.length; i++){
            ans[i] = input / arr[i];
            input = input % arr[i];

        }
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]+" nota(s) de R$ "+arr[i]+",00");
        }
    }

}