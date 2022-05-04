package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {
    private final int magicNumber = 30;
    private static Validator v;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    @Test
    public void testEmptyRuleSchema() {
        StringSchema schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("keep smiling"));
    }

    @Test
    public void testRequiredRuleSchema() {
        StringSchema schema = v.string();
        assertFalse(schema.required().isValid(""));
        assertTrue(schema.isValid("keep smiling"));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testContainsRuleSchema() {
        StringSchema schema = v.string();
        assertTrue(schema.contains("keep").isValid("keep smiling"));
        assertFalse(schema.isValid("It is a secret. Keep it!"));
        assertFalse(schema.contains("kpp").isValid("keep smiling"));
        assertFalse(schema.isValid("keep smiling"));
    }

    @Test
    public void testMinLengthRuleSchema() {
        StringSchema schema = v.string();
        assertTrue(schema.minLength(2).isValid("keep smiling"));
        assertFalse(schema.minLength(magicNumber).isValid("keep smiling"));
    }

    @Test
    public void testRulesJoinSchema() {
        StringSchema schema = v.string();
        assertTrue(schema.minLength(2).isValid("keep smiling"));
        assertFalse(schema.minLength(0).isValid(null));
        assertTrue(schema.isValid(""));
        assertFalse(schema.required().minLength(0).isValid(""));
        assertFalse(schema.required().minLength(magicNumber).contains("keep").isValid("keep smiling"));
        assertFalse(schema.required().minLength(2).contains("smile").isValid("keep smiling"));
        assertTrue(schema.required().minLength(2).contains("keep").isValid("keep smiling"));
    }
}
