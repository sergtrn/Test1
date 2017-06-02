package Learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey.Troyan on 02.06.2017.
 */
public class ParentChildInvoke {

    private static class Parent {
        public int pId = 0;

        public void test() {
            System.out.printf("Parent.test() %1$d\n\r", pId);
        }

        public void testParent() {
            System.out.println("Parent.testParent()");
        }
    }

    private static class Child extends  Parent {
        public int cId = 1;

        @Override
        public void test() {
            System.out.printf("Child.test() %1$d %2$d\n\r", pId, cId);
        }

        public void testChild() {
            System.out.println("Child.testChild()");
        }
    }

    static void use(Parent pr) {
        System.out.print("-- use(Parent) -- ");
        pr.test();
    }

    static void use(Child ch) {
        System.out.print("-- use(Child) -- ");
        ch.test();
    }

    public static void testParentChild() {
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

    public static void testLinking() {
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
}
