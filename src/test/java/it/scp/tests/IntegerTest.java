package it.scp.tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerTest {

    @Test
    public void testEquality() throws Exception {
        Integer i1 = 10;
        Integer i2 = 10;

        i1 = 11;

        Integer i3 = 10;

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        assertFalse(i1 == i3);
        assertTrue(i2.equals(i3));
    }
}
