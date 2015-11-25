package tv.lastpixel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by foxx on 11/24/15.
 */
public class AllPrimeSweep {
    private final List<Long> primes;
    private final ExecutorService threadPool;
    private final long start;
    private final long stop;
    private final long step;
    private long duration;

    public AllPrimeSweep(long start, long stop, long step, int threads) {
        this.primes = Collections.synchronizedList(new LinkedList<>());
        this.threadPool = Executors.newFixedThreadPool(threads);
        this.start = start;
        this.stop = stop;
        this.step = step;
        this.duration = 0L;
    }

    public void runTest() {
        long startTime = System.currentTimeMillis();
        for (long i = start; i < stop; i += step) {
            threadPool.execute(new PrimeWalker(i, Math.min(i + step, stop), primes));
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(60L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Interrupted.");
            Thread.currentThread().interrupt();
        }
        duration = System.currentTimeMillis() - startTime;
    }

    public long getDuration() {
        return duration;
    }

    public List<Long> getPrimes() {
        return primes;
    }
}
