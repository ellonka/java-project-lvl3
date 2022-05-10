package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {
    @Override
    public boolean isValid(Object parameter) {
        return (parameter == null || parameter instanceof Map) && super.isValid(parameter);
    }
    public MapSchema required() {
        addRule(x -> x != null);
        return this;
    }

    public MapSchema sizeof(int count) {
        addRule(x -> x.size() == count);
        return this;
    }

}
