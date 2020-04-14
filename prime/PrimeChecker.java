

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PrimeChecker {


    public static boolean isPrime(int i) {
        if (i <= 3)
            return true;
        else if ((i * i - 1) % 24 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        //Path path = Paths.get("/home/payam/Projects/Test_for_check_code/src/main/resources/primeTest.txt");
        StringBuilder builder = new StringBuilder();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                if (isPrime(Integer.parseInt(s))) {
                    builder.append('1');


                } else {
                    builder.append('0');

                }
                builder.append('\n');
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());

    }
}
