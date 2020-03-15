import com.lewandowski.ExtensionExtractor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtensionExtractorTest {

    @Test
    public void testPngFileExtension() {
        ExtensionExtractor extExtractor = new ExtensionExtractor();

        String filename = "someimage.png";
        String result = extExtractor.extractExtension(filename);
        String expectedResult = "png";

        assertEquals(expectedResult, result);
    }

    @Test
    public void testTxtFileExtension() {
        ExtensionExtractor extExtractor = new ExtensionExtractor();

        String filename = "sometext.txt";
        String result = extExtractor.extractExtension(filename);
        String expectedResult = "txt";

        assertEquals(expectedResult, result);
    }
}