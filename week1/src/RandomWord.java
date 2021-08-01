import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int i = 1;
        String word = "";
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            // Knuth method for uniform distribution
            if (StdRandom.bernoulli((double) 1/i))
                word = item;
            i++;
        }
        System.out.println(word);
    }
}
