package it.scp.tests;

import org.junit.*;
import static org.junit.Assert.*;

public class JUnitHelloWorldTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Running once - Before class");
    }

    @Before
    public void before() {
        System.out.println("Running before every test - Before");
    }

    @Test
    public void isGreaterTest() {
        System.out.println("Running isGreaterTest");
        JUnitHelloWorld jUnitHelloWorld = new JUnitHelloWorld();
        assertTrue("Num 1 is greater than Num 2", jUnitHelloWorld.isGreater(4, 3));
    }
    @After

    public void after() {
        System.out.println("Running after every test - After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Running oce - After class");
    }

}
