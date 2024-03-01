package Week1;

import java.io.IOException;
import java.util.Scanner;

public class Grenais {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        int inter =0, gremio = 0, emp = 0, grenais = 0, sn;
        do{
            int intCount = scan.nextInt();
            int greCount = scan.nextInt();
            System.out.println("Novo grenal (1-sim 2-nao)");
            sn = scan.nextInt();
            if(intCount > greCount){
                inter++;
            }
            else if(intCount < greCount){
                gremio++;
            }
            else{
                emp++;
            }
            grenais++;
        }while(sn == 1);
        String text = "\nNão houve vencedor";
        text = inter > gremio ? "\nInter venceu mais" : "\nGremio venceu mais";
        System.out.println(grenais + " grenais\nInter:"
                +inter+"\nGremio:"+gremio+"\nEmpates:"+emp+text);
    }
}
