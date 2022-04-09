import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person(21, "Penka", "Bulgaria");

        Class test = person.getClass();
        String name = test.getName();
        System.out.println("Class name: " + name);

        int modifier = test.getModifiers();
        String mod = Modifier.toString(modifier);
        System.out.println("Modifier: " + mod);
        System.out.println();

        Method[] methods = test.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method m : methods) {
            System.out.println("Method Name: " + m.getName());
            int methodModifier = m.getModifiers();
            System.out.println("Modifier: " + Modifier.toString(methodModifier));
            System.out.println("Return Types: " + m.getReturnType().getSimpleName());
            System.out.println();
        }

        System.out.println("Fields:");
        Field ageField = test.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 33);
        System.out.println("Name: " + ageField.getName());
        System.out.println("Modifiers: " + Modifier.toString(ageField.getModifiers()));
        System.out.println("Value: " + ageField.get(person));
        System.out.println();

        Field nameField = test.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "Ivanka");
        System.out.println("Name: " + nameField.getName());
        System.out.println("Modifiers: " + Modifier.toString(nameField.getModifiers()));
        System.out.println("Value: " + nameField.get(person));
        System.out.println();

        Field countryField = test.getDeclaredField("country");
        countryField.setAccessible(true);
        countryField.set(person, "Deutschland");
        System.out.println("Name: " + countryField.getName());
        System.out.println("Modifiers: " + Modifier.toString(nameField.getModifiers()));
        System.out.println("Value: " + countryField.get(person));
        System.out.println();

    }
}
