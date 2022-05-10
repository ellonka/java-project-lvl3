package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private List<Predicate<T>> rules = new LinkedList<>();

    public final void addRule(Predicate<T> predicate) {
        rules.add(predicate);
    }

    /**
     *
     * @param parameter for which validation is performed
     * @return true when validation is succeeded
     */
    public boolean isValid(Object parameter) {
        for (Predicate rule: rules) {
            if (!rule.test(parameter)) {
                return false;
            }
        }
        return true;
    }
}
