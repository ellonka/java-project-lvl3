package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    public void testRequiredRuleSchema() {
        NumberSchema schema = v.number();
        assertFalse(schema.required().isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid("5"));
    }

    @Test
    public void testPositiveRuleSchema() {
        NumberSchema schema = v.number();
        assertTrue(schema.positive().isValid(10));
        assertFalse(schema.isValid(-10));
    }

    @Test
    public void testRangeRuleSchema() {
        NumberSchema schema = v.number();
        schema.range(5, 10);
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
    }

}
