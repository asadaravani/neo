package Week1;
import java.io.IOException;
public class Sequence1098 {
    public static void main(String[] args) throws IOException {
        //Accepted!!!
        for (double i = 0.0; i <= 2.0; i += 0.2) {
            for (double j = 1.0; j <= 3.0; j += 1.0) {
                if(i != (int) i && j+i != (int) (j+i)){
                    System.out.printf("I=%.1f J=%.1f\n", i, i + j);
                }
                else{
                    System.out.printf("I=%.0f J=%.0f\n", i, i + j);
                }
            }
        }

    }
}
