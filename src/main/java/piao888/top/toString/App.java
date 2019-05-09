package piao888.top.toString;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        TestTostring testTostring= new TestTostring();
        System.out.println(testTostring.toString());
        System.out.println( testTostring.objConstructJson(TestTostring.class));

    }
}