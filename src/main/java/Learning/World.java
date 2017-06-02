package Learning;

/**
 * Created by Sergey.Troyan on 02.06.2017.
 */
public class World {

    private static final String HELLO_WORLD = "Hello world!";

    private static void say(String message) {
        System.out.println(message);
    }

    public static void sayHello() {
        say(HELLO_WORLD);
    }

    public static void testHelloWorld() {
        sayHello();
    }
}
