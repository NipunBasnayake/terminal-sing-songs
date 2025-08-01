import java.util.*;

public class SongLyricsPlayer {

    public static void main(String[] args) {
        List<LyricLine> lyrics = Arrays.asList(
                new LyricLine("Hello, it's me", 2, AnsiColors.RED),
                new LyricLine("I was wondering if after all these years", 4, AnsiColors.GREEN),
                new LyricLine("You'd like to meet", 3, AnsiColors.YELLOW));

        for (LyricLine line : lyrics) {
            printTypingEffectWithDuration(line.text, line.colorCode, line.durationInSeconds * 1000);
            System.out.println(); 
        }
    }

    public static void printTypingEffectWithDuration(String text, String colorCode, int totalDurationMs) {
        int length = text.length();
        int delayPerChar = totalDurationMs / length;

        for (char c : text.toCharArray()) {
            System.out.print(colorCode + c + AnsiColors.RESET);
            System.out.flush();
            try {
                Thread.sleep(delayPerChar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
