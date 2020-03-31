

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeChecker {

    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }


    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                if (isPrime(Integer.parseInt(s))) {
                    System.out.println(1);

                } else {
                    System.out.println(0);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
