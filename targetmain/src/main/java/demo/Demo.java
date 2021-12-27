package demo;

/**
 * @author yousj
 * @since 2021-12-27
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        while (true) {
            Thread.sleep(5000);
            System.out.println(new Test().getNumber());
        }
    }
}
