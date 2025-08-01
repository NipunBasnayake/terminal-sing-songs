import java.util.*;

public class SongLyricsPlayer {

    public static void main(String[] args) {
        List<LyricLine> lyrics = Arrays.asList(
                new LyricLine("\nතාරුකා නිවා", 2, AnsiColors.RED),
                new LyricLine("දුර ඈත තනි වෙලා", 3, AnsiColors.RED),
                new LyricLine("කොහේ ගියාද දිව්\u200Dයාංගනා", 4, AnsiColors.RED),

                new LyricLine("             ", 2, AnsiColors.RED),

                new LyricLine("ජීවිතේ කියා", 2, AnsiColors.GREEN),
                new LyricLine("පෙර දාක රැවටිලා", 3, AnsiColors.GREEN),
                new LyricLine("මගේ නොවේද දිව්\u200Dයාංගනා", 4, AnsiColors.GREEN),

                new LyricLine("             ", 2, AnsiColors.RED),

                new LyricLine("නික්මී නොයා", 2, AnsiColors.BLUE),
                new LyricLine("මහදේ දොර වසා", 3, AnsiColors.BLUE),
                new LyricLine("හදේ රැඳෙන්න දිව්\u200Dයාංගනා", 4, AnsiColors.BLUE),
                new LyricLine("ළං වී ඉඳින්න දිව්\u200Dයාංගනා", 4, AnsiColors.BLUE)
        );

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
