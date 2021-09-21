package group2.asd.uts.edu.au.opal.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomerClass {
    @Test
    public void testCustomerConstructor() {
        String str = "Junit test";
        assertEquals(str, "Junit test");
    }

    @Test
    public void testConvertClassToDocument() {
        assertEquals("Expected", "Actual");
    }


}
