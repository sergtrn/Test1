package Learning;

/**
 * Created by Sergey.Troyan on 02.06.2017.
 */
public class VarExchange {

    static class StringWrapper {
        public String str;
        public  StringWrapper(String str) {
            this.str = str;
        }
    }

    static void exchange1(String a, String b) {
        System.out.println("exchange1");
        String c = b;
        b = a;
        a = c;
    }

    static void exchange2(StringWrapper a, StringWrapper b) {
        System.out.println("exchange2");
        String c = b.str;
        b.str = a.str;
        a.str = c;
    }

    static void testExchange() {
        String a0 = "a";
        String a = a0;
        String b = "b";

        System.out.printf("a0=%1$s; a=%2$s; b=%3$s\n\r", a0, a, b);
        exchange1(a, b);
        System.out.printf("a0=%1$s; a=%2$s; b=%3$s\n\r", a0, a, b);

        String aa = "aa";
        StringWrapper swa0 = new StringWrapper(aa);
        StringWrapper swa = swa0;
        StringWrapper swb = new StringWrapper("bb");

        System.out.printf("aa=%1$s; swa0=%2$s; swa=%3$s; swb=%4$s\n\r", aa, swa0.str, swa.str, swb.str);
        exchange2(swa, swb);
        System.out.printf("aa=%1$s; swa0=%2$s; swa=%3$s; swb=%4$s\n\r", aa, swa0.str, swa.str, swb.str);

        System.out.printf("swa.getClass()=%1$s; swb.getClass()=%2$s\n\r",swa.getClass(), swb.getClass());
        System.out.printf("swa.hashCode()=%1$d; swb.hashCode()=%2$d\n\r",swa.hashCode(), swb.hashCode());
        System.out.printf("swa.toString()=%1$s; swb.toString()=%2$s\n\r",swa.toString(), swb.toString());
    }
}
