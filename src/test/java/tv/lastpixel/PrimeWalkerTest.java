package tv.lastpixel;

import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by foxx on 11/24/15.
 */
public class PrimeWalkerTest {
    private List<Long> primes;

    @DataProvider
    public Object[][] intputsOutputs() {
        return new Object[][]{
                {new Long[]{0L, 1L}, new Long[]{}},
                {new Long[]{0L, 2L}, new Long[]{}},
                {new Long[]{0L, 3L}, new Long[]{2L}},
                {new Long[]{0L, 5L}, new Long[]{2L, 3L}},
                {new Long[]{0L, 6L}, new Long[]{2L, 3L, 5L}},
                {new Long[]{11L, 20L}, new Long[]{11L, 13L, 17L, 19L}},
                {new Long[]{1993L, 1994L}, new Long[]{1993L}},
        };
    }

    @BeforeTest
    public void initialize() {
        primes = new LinkedList<>();
    }

    @BeforeMethod
    public void reinitialize() {
        primes.clear();
    }

    @Test(dataProvider = "intputsOutputs")
    public void testRun(Long[] limits, Long[] expectedPrimes) throws Exception {
        PrimeWalker pw = new PrimeWalker(limits[0], limits[1], primes);
        pw.run();
        assertEquals(primes, Arrays.asList(expectedPrimes));
    }
}