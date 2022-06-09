package test.java.parserTest;

import main.java.com.Parsers.HtmlParser;
import main.java.com.Parsers.Parser;
import org.junit.jupiter.api.Test;
import javax.swing.text.BadLocationException;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class HtmlParserTest {

    @Test
    public void HtmlParserTest() throws BadLocationException, IOException {
        File filename = new File("src/test/java/resources/theory_breakdown_final.html");
        Parser technology = new HtmlParser();
        //root.listFiles()
        StringBuilder Line = new StringBuilder();
        technology.Parse(filename.getAbsolutePath(), Line);
        String trueResult = "test html\n" +  "yo\n";
        assertEquals(trueResult, Line.toString());
    }
}
