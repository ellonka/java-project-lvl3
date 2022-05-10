package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();
//
//        System.out.println(schema.minLength(2).isValid("dfefewf"));
//        System.out.println(schema.minLength(0).isValid("h"));
//        System.out.println(schema.contains("smile").isValid("keep smiling"));
//        System.out.println(schema.contains("keep").isValid("keep smiling"));
//        System.out.println(schema.contains("smile").isValid("keep smiling"));
//        Integer good;
//        System.out.println(good instanceof Integer);
    }
}
