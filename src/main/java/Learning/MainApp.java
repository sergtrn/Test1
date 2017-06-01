package Learning;

import org.apache.camel.main.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * A Camel Application
 */
public class MainApp {

    static class StringWrapper {
        public String str;
        public  StringWrapper(String str) {
            this.str = str;
        }
    }

    static void Exchange1(String a, String b) {
        System.out.println("Exchange1");
        String c = b;
        b = a;
        a = c;
    }

    static void Exchange2(StringWrapper a, StringWrapper b) {
        System.out.println("Exchange2");
        String c = b.str;
        b.str = a.str;
        a.str = c;
    }

    static class Parent {
        public int pId = 0;

        public void test() {
            System.out.printf("Parent.test() %1$d\n\r", pId);
        }

        public void testParent() {
            System.out.println("Parent.testParent()");
        }
    }

    static class Child extends  Parent {
        public int cId = 1;

        @Override
        public void test() {
            System.out.printf("Child.test() %1$d %2$d\n\r", pId, cId);
        }

        public void testChild() {
            System.out.println("Child.testChild()");
        }

    }

    static void testHelloWoprld() {
        System.out.println("Hello World!");
    }

    static void testExchange() {
        String a0 = "a";
        String a = a0;
        String b = "b";

        System.out.printf("a0=%1$s; a=%2$s; b=%3$s\n\r", a0, a, b);
        Exchange1(a, b);
        System.out.printf("a0=%1$s; a=%2$s; b=%3$s\n\r", a0, a, b);

        String aa = "aa";
        StringWrapper swa0 = new StringWrapper(aa);
        StringWrapper swa = swa0;
        StringWrapper swb = new StringWrapper("bb");

        System.out.printf("aa=%1$s; swa0=%2$s; swa=%3$s; swb=%4$s\n\r", aa, swa0.str, swa.str, swb.str);
        Exchange2(swa, swb);
        System.out.printf("aa=%1$s; swa0=%2$s; swa=%3$s; swb=%4$s\n\r", aa, swa0.str, swa.str, swb.str);

        System.out.printf("swa.getClass()=%1$s; swb.getClass()=%2$s\n\r",swa.getClass(), swb.getClass());
        System.out.printf("swa.hashCode()=%1$d; swb.hashCode()=%2$d\n\r",swa.hashCode(), swb.hashCode());
        System.out.printf("swa.toString()=%1$s; swb.toString()=%2$s\n\r",swa.toString(), swb.toString());
    }

    static void testParentChild() {
        Parent pr = new Parent();
        Child ch = new Child();
        Parent prCh = ch;

        System.out.println("== pr ==");
        pr.test();
        pr.testParent();
        pr.pId = 2;
        pr.test();

        System.out.println("== ch ==");
        ch.test();
        ch.testParent();
        ch.testChild();
        ch.pId = 11;
        ch.cId = 12;
        ch.test();

        System.out.println("== prCh ==");
        prCh.test();
        prCh.testParent();
        prCh.pId = 22;
        prCh.test();

        System.out.println("== ch ==");
        ch.test();

        List<Parent> lp = new ArrayList<Parent>();
        lp.add(pr);
        lp.add(ch);
        lp.add(prCh);

        System.out.println("== lp 1. for ==");
        for (Parent p : lp) {
            p.test();
        }

        System.out.println("== lp 2. stream().forEach ==");
        lp.stream().forEach(p -> { ++p.pId; p.test(); });

        System.out.println("== lp 3. stream().forEach(Parent::test) ==");
        lp.stream().forEach(Parent::test);
    }

    static void use(Parent pr) {
        System.out.print("-- use(Parent) -- ");
        pr.test();
    }

    static void use(Child ch) {
        System.out.print("-- use(Child) -- ");
        ch.test();
    }

    static void testLinking() {
        Parent pr = new Parent();
        Child ch = new Child();
        Parent prCh = ch;

        System.out.println("== use(pr) ==");
        use(pr);
        System.out.println("== use(ch) ==");
        use(ch);
        System.out.println("== use(prCh) ==");
        use(prCh);
    }

    public interface ClickListener {
        void onClick();
    }

    static class Listener1 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 1: BAM!");
        }
    }

    static class Listener2 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 2: BOM!");
        }
    }

    static class Listener3 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 3: BUM!");
        }
    }

    static class TestListenerButton {
        private List<ClickListener> listeners;

        public TestListenerButton () {
            listeners = new ArrayList<>();
        }

        public void signListener(ClickListener listener) {
            listeners.add(listener);
        }

        public void unsignListener(ClickListener listener) {
            listeners.remove(listener);
        }

        public void pushButton() {
            propagatePush();
        }

        private void propagatePush() {
            for (ClickListener cl : listeners) {
                if (cl == null) continue;
                cl.onClick();
           }
        }
    }

    private static void testListener() {
        TestListenerButton tlb = new TestListenerButton();
        ClickListener cl1 = new Listener1();
        ClickListener cl2 = new Listener2();
        ClickListener cl3 = new Listener3();

        tlb.signListener(cl1);
        tlb.signListener(cl2);
        tlb.signListener(cl3);

        System.out.println("== 3 signed ==");
        tlb.pushButton();

        tlb.unsignListener(cl2);

        System.out.println("== 2 signed ==");
        tlb.pushButton();
    }

    private static void testParse(String str) {
        int i = Integer.parseInt(str);
        System.out.printf("i=%1$d", i);
    }

    /**
     * A main() so we can easily run these routing rules in our IDE
     */

    public static void main(String... args) throws Exception {
        //testHelloWoprld();
        //testExchange();
        //testParentChild();
        //testLinking();
        //testListener();
        testParse("1");
    }

}

