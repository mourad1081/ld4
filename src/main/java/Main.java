import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game();

        int max = 1000;
        // mes x
        System.out.print("x = [");
        for (int i = 0; i < max; i++)
            System.out.print(i + ", ");
        System.out.println("]");
        // mes y
        for(int i = 0; i < max; i++){
            game.play();
        }

        System.out.print("y1 = ");
        System.out.println(Arrays.toString(game.logStatCooperatorLuxe.toArray()));
        System.out.print("y2 = ");
        System.out.println(Arrays.toString(game.logStatDefectismeLuxe.toArray()));
        System.out.print("y3 = ");
        System.out.println(Arrays.toString(game.logStatFrontNational.toArray()));

    }
}
