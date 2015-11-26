package net.gfu.seminar.spring.helloworld.student;

import net.gfu.seminar.spring.lab.student.App;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream printOut = new PrintStream(os);
        System.setOut(printOut);
        App.main(new String[]{"Rainer", "Unsinn"});
        printOut.flush();
        assertThat(os.toString("UTF-8"), containsString("Rainer Unsinn"));
    }
}
