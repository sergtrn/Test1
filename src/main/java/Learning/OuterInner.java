package Learning;

/**
 * Created by Sergey.Troyan on 02.06.2017.
 */
public class OuterInner {

    static class ABC {
        private class XYZ {
            private int x=10;
        }

        public static void testInner() {
            ABC.XYZ xx = new ABC().new XYZ();
            System.out.println("xx.x :: "+xx.x);
            xx.x += 10;
            System.out.println("xx.x :: "+xx.x);
        }
//??? static / instances of objects ???
        private static class Inner1 { private static int test1 = 1; }
        private static class Inner2 { private static int test2 = ++new Inner1().test1; }

        public static void testStaticInner1_2() {
            //System.out.println("Inner2.test2 :: "+ new Inner2().test2);
            Inner1 in1 = new Inner1();
            System.out.printf("Inner1.test1 :: %1$d\n\r", in1.test1);
            in1.test1 += 10;
            System.out.printf("Inner1.test1 :: %1$d\n\r", in1.test1);
            Inner2 in2 = new Inner2();
            System.out.printf("Inner1.test1 :: %1$d\n\r", in1.test1);
            System.out.printf("Inner2.test2 :: %1$d\n\r", in2.test2);
            System.out.printf("Inner2.test2 :: %1$d\n\r", ++in2.test2);
            System.out.printf("Inner2.test2 :: %1$d\n\r", ++in2.test2);
            System.out.printf("Inner2.test2 :: %1$d\n\r", in2.test2);
            //System.out.printf("new Inner2.test2 :: %1$d\n\r", new Inner2().test2);
            System.out.printf("new Inner1.test1 :: %1$d\n\r", new Inner1().test1);
        }
    }

    public static void testOuterInner() {
        ABC.testInner();
        System.out.println("");
        ABC.testStaticInner1_2();
    }
}
