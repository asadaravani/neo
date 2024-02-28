package Week1;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class BankNotesCoins {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        bankNotes(scan.nextDouble());
    }
    public static void bankNotes(double input){
        DecimalFormat df = new DecimalFormat("0.00");
        double[] arr = {100,50,20,10,5,2,6666,1,0.50, 0.25, 0.10, 0.05, 0.01};
        int[] ans = new int[arr.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = (int) (input / arr[i]);
            input = input % arr[i];

        }
        System.out.println("NOTAS:");
        for(int i=0; i<ans.length; i++){
            if(i==6){System.out.println("MOEDAS:"); continue;}
            if(i>6){
                System.out.println(ans[i]+" moeda(s) de R$ "+ df.format(arr[i]));
            }
            else{
                System.out.println(ans[i]+" nota(s) de R$ "+df.format(arr[i]));
            }
        }
    }

}