package Week1;

import java.io.IOException;
import java.util.Scanner;

public class GameTime1047 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        Scanner scan = new Scanner(System.in);
        int ih = scan.nextInt();
        int im = scan.nextInt();
        int fh = scan.nextInt();
        int fm = scan.nextInt();
        printDuration(ih,im,fh,fm);

    }
    public static void printDuration(int ih, int im, int fh, int fm){
        int h, m;
        h= fh - ih;
        m= fm - im;
        if(h==0 && m ==0){h =24; m = 0;}
        if(m<0 && h>0){
            h = h-1;
            m = 60 + m;
        }
        if(m<0 && h<0){
            h = 23 + h;
            m = 60 + m;
        }
        if(m<0 && h==0){
            h = 23 + h;
            m = 60 + m;
        }
        System.out.println("O JOGO DUROU "+h+" HORA(S) E "+m+" MINUTO(S)");
    }
}
