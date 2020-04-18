

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PrimeChecker {
    public static final  String ZERO = "0\n";
    public static final  String ONE = "1\n";
    public static void main(String[] args) {
        try {
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            args[0]), StandardCharsets.US_ASCII));
            String line;
            OutputStream out = new BufferedOutputStream(System.out);
            while ((line = in.readLine()) != null) {
                out.write((isPrime(Integer.parseInt(line)) ).getBytes());
            }
            out.flush();
            in.close();
        } catch (Exception ex) {
        }
    }

    private static String isPrime(int num) {
        if (num <= 3) return ONE;

        int max = (int) Math.sqrt(num) + 1;
        for (int i = 3; i <= max; i += 2) {
            if (num % i == 0) {
                return ZERO;
            }
        }
        return ONE;
    }


}



