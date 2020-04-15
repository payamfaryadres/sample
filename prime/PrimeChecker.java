


import java.nio.charset.StandardCharsets;
import java.io.*;
public class PrimeChecker {


    static final String ZERO="0\n";
    static final String ONE="1\n";
    public static String isPrime(long input_number) {
        if (input_number <= 3) return ONE;
        if (input_number % 2 == 0) return ZERO;
        int max = (int) Math.sqrt(input_number) + 1;
        for (int i = 3; i <= max; i += 2) {
            if (input_number % i == 0) {
                return ZERO;
            }
        }
        return ONE;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            OutputStream out = new BufferedOutputStream ( System.out );
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                out.write((isPrime(Integer.parseInt(line))).getBytes());
            }
            in.close();
            out.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.print(builder.toString());

    }
}
