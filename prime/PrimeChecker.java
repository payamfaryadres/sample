

import java.util.*;
import java.io.*;
public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
            OutputStream out = new BufferedOutputStream ( System.out );
            while(sc.hasNext()) {
                String num = sc.nextLine();
                out.write((isPrime(Integer.parseInt(num)) + "\n").getBytes());
            }
            out.flush();
        }
        catch(Exception ex) {}
    }

    private static int isPrime(int num) {
        if (num <= 3) return 1;
        if (num % 2 == 0) return 0;
        int max = (int) Math.sqrt(num) + 1;
        for (int i = 3; i <= max; i+=2) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}



