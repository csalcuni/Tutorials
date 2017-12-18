package it.scp.tests.reports;

import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JUnitReportGenerationTest {

    private String developer = "Vinod";

    @Test
    public void instanceOfTest() {
        assertThat(new ArrayList<String>(), instanceOf(List.class));
    }

    @Test
    public void assertTrueTest() {
        assertTrue(true);
    }

    @Test
    public void failTest() {
        assertThat(developer, is("Any"));
    }
}
