package it.scp.tests;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(ConcurrentTestRunner.class)
public class CountCheckTest {
    private CountCheck  countCheck = new CountCheck();
    private int c = 2;
    private static final int THREAD_COUNT = 5;

    @Before
    public void initializeCountCheck() {
        countCheck.initialize(2);
    }

    @Test
    @ThreadCount(THREAD_COUNT)
    public void addOne() {
        System.out.println("Adding One");
        countCheck.addOne();
        assertEquals("Test verification", ++c, countCheck.getCount());
    }

    @After
    public void testCount() {
        assertEquals("Value should be 7", 7, countCheck.getCount());
    }


}
