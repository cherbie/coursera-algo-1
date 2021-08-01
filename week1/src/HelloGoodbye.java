public class HelloGoodbye {
    public static void main(String[] args)
    {
        if (args.length != 2)
            System.out.println("Usage:\n java HelloGoodbye name1 name2");
        else {
            // Hello
            System.out.println("Hello " + args[0] + " and " + args[1] + ".");
            // Goodbye
            System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
        }
    }
}
