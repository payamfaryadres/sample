

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PrimeChecker {


    public static char isPrime(int input_number) {
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
        Path path = Paths.get(args[0]);
        StringBuilder builder = new StringBuilder();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                    builder.append(isPrime(Integer.parseInt(s)));
                    builder.append('\n');
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());

    }
}
