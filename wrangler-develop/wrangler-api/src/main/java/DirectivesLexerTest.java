import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DirectivesLexerTest {

    // Test for ByteSize
    @Test
    public void testByteSize() {
        String input = "5GB";  // Test input
        assertTrue(parse(input, TokenType.BYTESIZE));  // Check that ByteSize is correctly parsed
    }

    // Test for TimeDuration
    @Test
    public void testTimeDuration() {
        String input = "30m";  // Test input
        assertTrue(parse(input, TokenType.TIMEDURATION));  // Check that TimeDuration is correctly parsed
    }

    // Helper function to parse the input and check token type (you can customize this method based on your logic)
    private boolean parse(String input, TokenType expectedTokenType) {
        // Assuming you have a lexer/parser that returns tokens
        DirectivesLexer lexer = new DirectivesLexer(CharStreams.fromString(input));
        Token token = lexer.nextToken();
        
        // Check if the token type matches the expected token type
        return token.getType() == expectedTokenType.ordinal();
    }
}
