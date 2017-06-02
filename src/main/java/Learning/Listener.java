package Learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey.Troyan on 02.06.2017.
 */
public class Listener {

    private interface ClickListener {
        void onClick();
    }

    private static class Listener1 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 1: BAM!");
        }
    }

    private static class Listener2 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 2: BOM!");
        }
    }

    private static class Listener3 implements ClickListener {
        @Override
        public void onClick() {
            System.out.println("listener 3: BUM!");
        }
    }

    private static class TestListenerButton {
        private List<ClickListener> listeners;

        public TestListenerButton() {
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

    public static void testListener() {
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
}
