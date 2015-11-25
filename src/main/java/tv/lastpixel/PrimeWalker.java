package tv.lastpixel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by foxx on 11/24/15.
 */
public class PrimeWalker implements Runnable {
    private final long start;
    private final long stop;
    private final List<Long> primes;
    private final List<Long> globalPrimes;

    public PrimeWalker(long start, long stop, List<Long> globalPrimes) {
        this.start = start;
        this.stop = stop;
        this.primes = new LinkedList<>();
        this.globalPrimes = globalPrimes;
    }

    @Override
    public void run() {
        for (long i = start; i < stop; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        globalPrimes.addAll(primes);
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
