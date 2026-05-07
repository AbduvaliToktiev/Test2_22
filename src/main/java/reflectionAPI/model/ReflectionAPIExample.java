package reflectionAPI.model;

import java.lang.reflect.*;

public class ReflectionAPIExample {
    public static void main(String[] args) {
        User user = new User(25L, "Ivan", 14);
        testMethod(user);
        // testFields(user);
        //  Class<? extends User> userClass = user.getClass();
        //  Class<User> userClass1 = User.class;
        //  System.out.println(userClass == userClass1);
        //  testConstructor();
    }

    private static void testConstructor() {
        Constructor<User> constructor = null;
        try {
            constructor = User.class.getConstructor(Long.class, String.class);
            User petr = constructor.newInstance(5L, "Petr");
            System.out.println(petr);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testFields(User user) {
        Field[] declaredFields = User.class.getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = null;
            try {
                value = declaredField.get(user);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            System.out.println(declaredField.getModifiers());
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(value);
        }
    }

    private static void testMethod(User user) {
        Method method = null;
        try {
            method = user.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(user, "Pavel");
            System.out.println(user);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private class Test1 {

    }

    private static class Test2 {

    }

    private enum Test3 {
        ONE, TWO
    }
}
