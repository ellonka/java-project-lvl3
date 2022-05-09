package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    @Override
    public boolean isValid(Object parameter) {
        return parameter instanceof Integer && super.isValid(parameter);
    }

    public NumberSchema required() {
        rules.add(x -> x != null);
        return this;
    }

    public NumberSchema positive() {
        rules.add(x -> x > 0);
        return this;
    }

    public NumberSchema range(final int value1, final int value2) {
        rules.add(x -> (x >= value1 && x <= value2));
        return this;
    }
}
