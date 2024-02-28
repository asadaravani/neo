package Week1;

import java.io.IOException;
import java.util.Scanner;
public class Banknotes1018 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        bankNotes(scan.nextInt()); //answer was 5%, didnt understand this
    }
    public static void bankNotes(int input){
        int[] arr = {100,50,20,10,5,2,1};
        int[] ans = new int[arr.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = input / arr[i];
            input = input % arr[i];

        }
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]+" nota(s) de R$ "+arr[i]+",00");
        }
    }

}