package it.scp.tests;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void test() {
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "test";
        String obj4 = "test";
        String obj5 = null;
        int var1 = 1;
        int var2 = 2;

        int[] arithmetic1 = {1,2,3,4};
        int[] arithmetic2 = {1,2,3,4};

        assertEquals(obj1, obj2);
        assertSame(obj3, obj4);
        assertNotSame(obj2, obj4);
        assertNotNull(obj1);
        assertNull(obj5);
        assertTrue(var1 != var2);
        assertArrayEquals(arithmetic1, arithmetic2);
    }

    @Test
    public void testSimpleObject() {
        SimpleObject s1 = new SimpleObject(1, "Uno");
        SimpleObject s2 = new SimpleObject(1, "Uno");

        System.out.println("S1 == S2 " + (s1 == s2));
        System.out.println("S1 equals S2 " + (s1.equals(s2)));

        assertNotSame(s1, s2);
        assertEquals(s1, s2);

    }

    class SimpleObject {
        private int prop1;
        private String prop2;

        SimpleObject(int p1, String p2) {
            this.prop1 = p1;
            this.prop2 = p2;
        }

        public int getProp1() {
            return prop1;
        }

        public void setProp1(int prop1) {
            this.prop1 = prop1;
        }

        public String getProp2() {
            return prop2;
        }

        public void setProp2(String prop2) {
            this.prop2 = prop2;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof SimpleObject) && (this.prop1 == ((SimpleObject)obj).prop1 && this.prop2 == ((SimpleObject)obj).prop2)  ;
        }
    }
}
