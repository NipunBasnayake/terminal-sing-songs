import java.util.*;

public class SongLyricsPlayer {

    public static void main(String[] args) {
        List<LyricLine> lyrics = Arrays.asList(
            new LyricLine("Hello, it's me", 1, AnsiColors.RED),
            new LyricLine("I was wondering if after all these years", 4, AnsiColors.GREEN),
            new LyricLine("You'd like to meet", 7, AnsiColors.YELLOW)
        );

        long startTime = System.currentTimeMillis();

        for (LyricLine line : lyrics) {
            long delay = line.timeInSeconds * 1000 - (System.currentTimeMillis() - startTime);
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(line.colorCode + line.text + AnsiColors.RESET);
        }
    }
}
