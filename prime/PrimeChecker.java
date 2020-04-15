

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = null;
        try {

            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(
                            args[0]), StandardCharsets.UTF_8));
            String line;
            OutputStream out = new BufferedOutputStream(System.out);
            while ((line = in.readLine()) != null) {
                out.write((isPrime(Integer.parseInt(line)) + "\n").getBytes());
            }
            out.flush();
            in.close();
        } catch (Exception ex) {
        }
    }

    private static int isPrime(int num) {
        if (num <= 3) return 1;
        int max = (int) Math.sqrt(num) + 1;
        for (int i = 3; i <= max; i += 2) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}



