package it.scp.tests.listeners;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestClassB {
    @Test
    public void test_B_1() throws Exception {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void test_B_2() throws Exception {
        assertTrue(2==4);
    }
}
