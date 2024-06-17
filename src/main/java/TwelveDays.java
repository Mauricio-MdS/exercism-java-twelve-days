import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwelveDays {
    public static String verse(int verseNumber) {
        return christmasVerse(verseNumber) + gifts(verseNumber);
    }

    public static String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(TwelveDays::verse)
                .collect(Collectors.joining("\n"));
    }
    
    public static String sing() {
        return verses(1, 12);
    }

    private static String christmasVerse(int day) {
        String[] days = {
                "first", "second", "third", "fourth", "fifth", "sixth",
                "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
        };
        return "On the " + days[day - 1] + " day of Christmas my true love gave to me: ";
    }

    private static String gifts(int numberOfGifts) {
        if (numberOfGifts == 1) return gift(1);

        return IntStream.rangeClosed(2, numberOfGifts)
                .mapToObj(i -> gift(numberOfGifts - i + 2))
                .collect(Collectors.joining(", ", "", ", and " + gift(1)));
    }

    private static String gift(int giftNumber) {
        String[] gifts = {
                "a Partridge in a Pear Tree.\n", "two Turtle Doves", "three French Hens",
                "four Calling Birds", "five Gold Rings", "six Geese-a-Laying",
                "seven Swans-a-Swimming", "eight Maids-a-Milking", "nine Ladies Dancing",
                "ten Lords-a-Leaping", "eleven Pipers Piping", "twelve Drummers Drumming"
        };
        return gifts[giftNumber - 1];
    }
}
