import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {


    @Test
    public void snippet3 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("https://www.twitter.com"); 
        forTest1.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        forTest1.add("https://cse.ucsd.edu/");

        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }
    
    @Test
    public void snippet2 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("a.com"); //it's a nested link
        forTest1.add("a.com(())");
        forTest1.add("example.com");

        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }

    @Test
    public void snippet1 () throws IOException {
        ArrayList<String> forTest1 = new ArrayList<String>();
        forTest1.add("url.com");
        forTest1.add("`google.com");
        forTest1.add("google.com");
        forTest1.add("ucsd.edu");

        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(forTest1, MarkdownParse.getLinks(content));
    }

    /*
    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-thing.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testLinkAtBeginning() {
        String contents= "[link title](a.com)";
        List<String> expect = List.of("a.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceInURL() {
        String contents = "[title](space in-url.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSpaceBeforeParen() {
        String contents = "[title]   (should-not-count.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testNestedParens() throws IOException {
        String contents = Files.readString(Path.of("test-parens-inside-link.md"));
        List<String> expect = List.of("something.com()", "something.com((()))", "something.com", "boring.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testMissingCloseParen() throws IOException {
        String contents = Files.readString(Path.of("test-missing-paren-plus-test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    */
    
}
