package Learning;

/**
 * Created by Sergey.Troyan on 06.06.2017.
 *  Automatic Resource Management (ARM).
 */
public class ResourceARM implements AutoCloseable {

    public ResourceARM() {
        System.out.println("Resource created...");
    }
    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void close() {
        System.out.println("cleanup logic goes here...");
    }

    public static void testResourceARM() {
        try (ResourceARM resource = new ResourceARM()) {
            resource.op1();
            resource.op2();
        }
    }
}