package tv.lastpixel;

import org.testng.annotations.Test;

import java.util.stream.Collectors;

/**
 * Created by foxx on 11/24/15.
 */
public class AllPrimeSweepTest {
    @Test
    public void testAllPrimeSweep() {
        for (int threads = 1; threads < 16; threads++) {
            AllPrimeSweep aps = new AllPrimeSweep(0L, 10_000_000L, 1_000_000L, threads);
            aps.runTest();
            System.out.print(String.format("%4d threads: ", threads));
            System.out.println("Execution took " + aps.getDuration() + " milliseconds.");
            System.out.println("Got " + aps.getPrimes().size() + " primes:");
            /*
            System.out.println(
                    aps.getPrimes().stream()
                            .sorted()
                            .map(i -> i.toString())
                            .collect(Collectors.joining(", ")));
            */
        }
    }
}
