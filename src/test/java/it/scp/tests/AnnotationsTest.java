package it.scp.tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AnnotationsTest {

    private ArrayList<String> testList;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Running once - Before Class");
    }

    @Before
    public void before() {
        testList = new ArrayList<>();
        System.out.println("Running before each test - Before");
    }

    @Test
    public void testEmpty() {
        System.out.println("@Test: empty list");
        assertTrue(testList.isEmpty());
    }

    @Test
    public void testOneItem() {
        System.out.println("@Test: one item");
        testList.add("Ciccio");
        assertEquals(1, testList.size());
    }

    @After
    public void after() {
        testList.clear();
        System.out.println("Running after each test - After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Running once - After Class");
    }

}
