package main.java.com.Parsers;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import main.java.com.Parsers.Parser;
import org.jsoup.nodes.Element;

import java.io.*;


public class RtfParser implements Parser {
    @Override
    public void Parse(String file_name, StringBuilder Line) throws BadLocationException {
        DefaultStyledDocument styledDoc = null;
        try {
            styledDoc = new DefaultStyledDocument();
            boolean need_to_write = false;
            InputStream is = new FileInputStream(file_name);
            new RTFEditorKit().read(is, styledDoc, 0);
            FileWriter writer = new FileWriter("result.txt", true);
            writer.write("\n------------------------------- " + file_name + " -------------------------------\n");
            writer.write(styledDoc.getText(0, styledDoc.getLength()));
            // Попытка заполнить Line
            writer.write("\n--------------------------------------------------------------\n");
            writer.close();
            FileReader fr = new FileReader("result.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (need_to_write) {
                    if (line.equals("--------------------------------------------------------------")) {
                        Line.append(line);
                        break;
                    }
                    Line.append(line);
                }
                if (!need_to_write && line.equals("------------------------------- src/test/java/resources/test.rtf -------------------------------")) {
                    Line.append(line);
                    need_to_write = true;
                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            reader.close();
            fr.close();

        } catch (BadLocationException e) {
            System.out.println("BadLocationException occurred when extracting text from RTF file:" + file_name);
        } catch (IOException e) {
            System.out.println("IOException occurred when extracting text from RTF file: " + file_name);
        }
    }
}