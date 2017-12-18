package it.scp.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ForEachTest {

    @Test(expected = NullPointerException.class)
    public void testForeachOfNullList() throws Exception {
        List<String> list = null;
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    @Test
    public void testForeachOfEmptyList() throws Exception {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (String s2 : list) {
            System.out.println(s2);
            count++;
        }

        assertEquals("Count should be equals zero", 0, count);
    }
}
