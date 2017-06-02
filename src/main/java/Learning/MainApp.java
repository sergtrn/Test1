package Learning;

import org.apache.camel.main.Main;

import java.util.ArrayList;
import java.util.List;

import static Learning.Listener.testListener;
import static Learning.OuterInner.testOuterInner;
import static Learning.ParentChildInvoke.testLinking;
import static Learning.ParentChildInvoke.testParentChild;
import static Learning.VarExchange.testExchange;
import static Learning.World.testHelloWorld;

/**
 * A Camel Application
 */
public class MainApp {

//    static void testHelloWorld() {
//        //System.out.println("Hello World!");
//        World.sayHello();
//    }

    private static void testParse(String str) {
        int i = Integer.parseInt(str);
        System.out.printf("i=%1$d", i);
    }

    /**
     * A main() so we can easily run these routing rules in our IDE
     */

    public static void main(String... args) throws Exception {
        //testHelloWorld();
        //testExchange();
        //testParentChild();
        //testLinking();
        //testListener();
        //testParse("1");
        testOuterInner();
    }

}

