import java.util.Vector;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWorld {
    public static void main(String[] args)
    {
        Vector<String> words = new Vector<String>();
        while (!StdIn.isEmpty()) {
            words.add(StdIn.readString());
        }
        int index = StdRandom.uniform(words.size());
        System.out.println(words.get(index));
    }
}
