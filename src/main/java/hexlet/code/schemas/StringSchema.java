package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public final class StringSchema implements Schema {
    private List<String> rules = new ArrayList<>();
    private int minLength;
    private StringBuilder strToCompare;

    @Override
    public boolean isValid(String parameter) {
        for (String rule: rules) {
            if (rule.equals("required")) {
                if (parameter == null || parameter.equals("")) {
                    return false;
                }
            }
            if (rule.equals("contains")) {
                if (!parameter.toString().contains(strToCompare)) {
                    return false;
                }
            }
            if (rule.equals("minLength")) {
                if (parameter == null) {
                    return false;
                }
                if (parameter.toString().length() < minLength) {
                    return false;
                }
            }
        }
        return true;
    }

    public StringSchema required() {
        rules.add("required");
        return this;
    }

    public StringSchema contains(String str) {
        rules.add("contains");
        strToCompare = new StringBuilder(str);
        return this;
    }

    public StringSchema minLength(int length) {
        rules.add("minLength");
        minLength = length;
        return this;
    }
}
