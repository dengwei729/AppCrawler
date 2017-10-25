package crawler.utils;

/**
 * Created by dengwei on 23/10/2017.
 */
public class Test {


    public static void main(String args[])  {
        for (int i=a(); i<b(); i++) {
            System.out.print("z");
        }
    }

    private static int a() {
        System.out.print("x");
        return  0;
    }

    private static int b() {
        System.out.print("y");
        return  5;
    }
}
