package Learning;

import java.util.function.Consumer;

/**
 * Created by Sergey.Troyan on 06.06.2017.
 */

//@FunctionalInterface
//public interface ExecuteAround {
//    abstract void execute();
//}

public class ExecuteAround {

    private ExecuteAround() {
        System.out.println("Creating object and allocating resources");
    }

    public void doOperation1() {
        System.out.println("Executing operation1");
    }

    public void doOperation2() {
        System.out.println("Executing operation2;  i=3/0");
        int i = 10/0;
    }

    public void doOperation3() {
        System.out.println("Executing operation3");
    }

    private void clear() {
        System.out.println("Clearing resources");
    }

    public static void use(Consumer<ExecuteAround> block) {
        ExecuteAround ea = new ExecuteAround();
        try {
            block.accept(ea);
        }
        catch (Exception e) {
            System.out.println("Catched exception:");
            System.out.println(e.getMessage());
        }
        finally {
            ea.clear();
        }
    }

    public static void testExecuteAround() {
        //ExecuteAround.use( (ExecuteAround ea) -> { ea.doOperation1(); ea.doOperation2(); ea.doOperation3(); } );
        ExecuteAround.use( ea -> { ea.doOperation1(); ea.doOperation2(); System.out.printf("1 / 0 = %1$d", (1 / 0)); ea.doOperation3(); } );
    }

}