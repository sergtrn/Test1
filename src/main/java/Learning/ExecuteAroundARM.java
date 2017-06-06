package Learning;

import java.util.function.Consumer;

/**
 * Created by Sergey.Troyan on 06.06.2017.
 */
public class ExecuteAroundARM implements AutoCloseable {

    private ExecuteAroundARM() {
        System.out.println("Creating object and allocating resources");
    }

    public void doOperation1() {
        System.out.println("Executing operation1");
    }

    public void doOperation2() {
        System.out.println("Executing operation2");
    }

    public void doOperation3() {
        System.out.println("Executing operation3");
    }

    public void close() {
        System.out.println("Clearing resources");
    }

    public static void execute(Consumer<ExecuteAroundARM> block) {
        try (ExecuteAroundARM ea = new ExecuteAroundARM()) {
            block.accept(ea);
        }
        catch (Exception e) {
            System.out.println("Catched exception:");
            System.out.println(e.getMessage());
        }
    }

    public static void testExecuteAroundARM() {
        //ExecuteAround.use( (ExecuteAroundARM ea) -> { ea.doOperation1(); ea.doOperation2(); ea.doOperation3(); } );
        ExecuteAroundARM.execute( ea -> { ea.doOperation1(); ea.doOperation2(); System.out.printf("1 / 0 = %1$d", (1 / 0)); ea.doOperation3(); } );
    }

}
