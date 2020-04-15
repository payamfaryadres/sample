

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class PrimeChecker {


    public static char isPrime(long input_number) {
        if (input_number <= 3) return '1';
        if (input_number % 2 == 0) return '0';
        int max = (int) Math.sqrt(input_number) + 1;
        for (int i = 3; i <= max; i+=2) {
            if (input_number % i == 0) {
                return '0';
            }
        }
        return '1';
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(isPrime(Long.parseLong(line)));
                builder.append('\n');
            }
            in.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        System.out.println(builder.toString());

    }
}
