package it.scp.tests.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.TestCase.fail;

public class A {
    @Test
    public void a() {
        fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
    }
}
