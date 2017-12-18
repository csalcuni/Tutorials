package it.scp.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalculateTest {

    private int expected;
    private int first;
    private int second;

    public CalculateTest(int expectedResult, int firstNumber, int secondNumber) {
        this.expected = expectedResult;
        this.first = firstNumber;
        this.second = secondNumber;
    }

    @Parameterized.Parameters
    public static List<Integer[]> addedNumbers() {
        return Arrays.asList(new Integer[][] {{3,1,2}, {5,2,3}, {7,3,4}, {9,4,5} });
    }

    @Test
    public void sumTest() {
        Calculate calculate = new Calculate();
        System.out.println("Addition with parameters : " + first + " and " + second);

        assertEquals(expected, calculate.sum(first, second));
    }

    @Test
    public void  testEqualsArrays() {
        Integer[] a1 = new Integer[] {1,2,3,4,5};
        Integer[] a2 = new Integer[] {1,2,3,4,5};

        System.out.println("@Test Arrays are equals");
        assertArrayEquals(a1, a2);

    }

}
