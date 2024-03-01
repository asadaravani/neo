package Week1;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class BankNotesCoins1021 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        bankNotes(scan.nextDouble());
    }
    public static void bankNotes(double input){
        DecimalFormat df = new DecimalFormat("0.00");
        int[] arr = {10000,5000,2000,1000,500,200,6666,100,50, 25, 10, 5, 1};
        int[] ans = new int[arr.length];
        int inputt = (int) (input*100);
        for(int i=0; i<ans.length; i++){
            ans[i] = (inputt / arr[i]);
            inputt = inputt % arr[i];

        }
        System.out.println("NOTAS:");
        for(int i=0; i<ans.length; i++){
            if(i==6){System.out.println("MOEDAS:"); continue;}
            if(i>6){
                System.out.println(ans[i]+" moeda(s) de R$ "+ df.format(arr[i] / 100.0));
            }
            else{
                System.out.println(ans[i]+" nota(s) de R$ "+df.format(arr[i] / 100.0));
            }
        }
    }

}