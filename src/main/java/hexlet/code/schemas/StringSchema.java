package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    @Override
    public boolean isValid(Object parameter) {
        return parameter instanceof String && super.isValid(parameter);
    }

    public StringSchema required() {
        rules.add(x -> (x != null && !(Objects.equals(x, ""))));
        return this;
    }

    public StringSchema contains(String strToCompare) {
        rules.add(x -> {
            if (x != null && x.contains(strToCompare)) {
                System.out.println(strToCompare);
                return true;
            }
            System.out.println(strToCompare);
            return false;
        });
        return this;
    }

    public StringSchema minLength(int minLength) {
        rules.add(x -> {
            if (x != null && x.length() >= minLength) {
                System.out.println(minLength);
                return true;
            }
            System.out.println(minLength);
            return false;
        });

        return this;
    }
}
