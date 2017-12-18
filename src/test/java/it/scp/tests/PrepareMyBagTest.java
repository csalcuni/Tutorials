package it.scp.tests;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PrepareMyBagTest {
    FirstDayAtSchool school = new FirstDayAtSchool();
    String[] bag = { "Books", "Notebooks", "Pens" };
    @Test
    public void testPrepareMyBag() {
        System.out.println("Inside testPrepareMyBag()");
        assertArrayEquals(bag, school.prepareMyBag());
    }
}
