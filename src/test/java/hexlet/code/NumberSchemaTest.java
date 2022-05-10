package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private final int ten = 10;
    private final int five = 5;
    private final int minusTen = -10;
    private final int four = 4;
    private final int eleven = 11;
    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    public void testRequiredRuleSchema() {
        NumberSchema schema = v.number();

        assertFalse(schema.required().isValid(null));
        assertTrue(schema.isValid(ten));
        assertFalse(schema.isValid("5"));
    }

    @Test
    public void testPositiveRuleSchema() {
        NumberSchema schema = v.number();
        assertTrue(schema.positive().isValid(ten));
        assertFalse(schema.isValid(minusTen));
    }

    @Test
    public void testRangeRuleSchema() {
        NumberSchema schema = v.number();
        schema.range(five, ten);
        assertFalse(schema.isValid(four));
        assertFalse(schema.isValid(eleven));
        assertTrue(schema.isValid(five));
        assertTrue(schema.isValid(ten));
    }

}
