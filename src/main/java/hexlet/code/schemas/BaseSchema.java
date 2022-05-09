package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected List<Predicate<T>> rules = new LinkedList<>();

    public boolean isValid(Object parameter) {
        for (Predicate rule: rules) {
            if (!rule.test(parameter)) {
                return false;
            }
        }
        return true;
    }
}
