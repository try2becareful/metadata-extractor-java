package test.java.parserTest;

import main.java.com.Parsers.Parser;
import main.java.com.Parsers.RtfParser;
import org.junit.jupiter.api.Test;

import javax.swing.text.BadLocationException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;

class RtfParserTest {

    @Test
    public void rtfParserTest() throws BadLocationException, IOException {
        String filename = "src/test/java/resources/test.rtf";
        Parser technology = new RtfParser();
        StringBuilder Line = new StringBuilder();
        technology.Parse(filename, Line);
        String trueResult = "This is plain text.\n";
        assertEquals(trueResult, Line.toString());
    }
}