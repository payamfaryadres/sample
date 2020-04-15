

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class PrimeChecker {


    public static char isPrime(long input_number) {
        if (input_number <= 3 || input_number == 5 || input_number == 7)
            return '1';
        else if (input_number % 2 == 0 || input_number % 3 == 0 || input_number % 5 == 0 || input_number % 7 == 0)
            return '0';

        int input_number_sqrt = (int) (Math.sqrt(input_number) + 1);
        for (int counter = 11; counter < input_number_sqrt; counter += 2) {
            if (input_number % counter == 0) {
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
