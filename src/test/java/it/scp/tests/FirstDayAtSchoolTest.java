package it.scp.tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class FirstDayAtSchoolTest {

    private FirstDayAtSchool firstDayAtSchool = new FirstDayAtSchool();
    private String[] bag1 = { "Books", "Notebooks", "Pens" };
    private String[] bag2 = { "Books", "Notebooks", "Pens", "Pencils" };

    @Test
    public void testPrepareMyBag() {
        System.out.println("Inside testPrepareMyBag()");
        String[] bag = firstDayAtSchool.prepareMyBag();
        assertArrayEquals(bag1, bag);
    }

    @Test
    public void testAddPencils() {
        System.out.println("Inside testAddPencis()");
        String[] bag = firstDayAtSchool.addPencils();
        assertArrayEquals(bag2, bag);
    }

}
