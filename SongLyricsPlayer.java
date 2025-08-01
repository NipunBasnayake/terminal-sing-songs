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
            printTypingEffect(line.text, line.colorCode, 50);
            System.out.println();
        }
    }

    public static void printTypingEffect(String text, String colorCode, int delayPerCharMs) {
        for (char c : text.toCharArray()) {
            System.out.print(colorCode + c + AnsiColors.RESET);
            System.out.flush();
            try {
                Thread.sleep(delayPerCharMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
