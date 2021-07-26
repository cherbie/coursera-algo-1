import java.lang.ref.Cleaner;

public class HelloGoodbye {
    public static void main(String[] args)
    {
        HelloGoodbye.printConcat("Hello", args);
        HelloGoodbye.printConcat("Goodbye", args);
    }

    private static void printConcat(String base, String[] args)
    {
        System.out.print(base);
        boolean isFirst = true;
        for (String arg : args)
        {
            String msg = " ";
            if (isFirst)
                isFirst = false;
            else
                msg += "and ";
            System.out.print(msg + arg);
        }
        System.out.println("");
    }
}
