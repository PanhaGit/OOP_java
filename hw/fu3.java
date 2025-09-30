package hw;

public class fu3 {
    /**
     * Color text print.
     */
    // private static final String RESET = "\u001B[0m";
    // private static final String BOLD = "\u001B[1m";
    private static final String ORANGE = "\u001B[38;5;208m";
    private static final String GOLD = "\u001B[38;5;220m";

    public static void main(String[] args) {

        fu3 error = new fu3();

        String[] lines = {
                "I wanna da-",
                "I wanna dance in the lights",
                "I wanna ro-",
                "I wanna rock your body",
                "I wanna go",
                "I wanna go for a ride",
                "Hop in the music and",
                "Rock your body",
                "Rock that body",
                "come on, come on",
                "Rock that body",
                "(Rock your body)",
                "Rock that body",
                "come on, come on",
                "Rock that body",
        };

        double[] charDelays = {
                0.06,
                0.05,
                0.07,
                0.08,
                0.08,
                0.068,
                0.07,
                0.08,
                0.069,
                0.035,
                0.05,
                0.03,
                0.049,
                0.035,
                0.08
        };

        double[] delays = {
                0.2,
                1,
                0.2,
                1,
                0.2,
                0.8,
                0.2,
                0.5,
                0.18,
                0.1,
                0.15,
                0.3,
                0.3,
                0.1,
                5
        };

        for (int i = 0; i < lines.length; i++) {
            error.typeLine(lines[i], charDelays[i]);
            error.typeLine(lines[i], charDelays[i]);
            error.sleepSeconds(delays[i]);
            error.sleepSeconds(delays[i]);
        }
    }

    /**
     * @text type String
     * @charDelaySec type double
     */
    public void typeLine(String text, double charDelaySec) {
        boolean isTextOrage = "(Rock your body)".equals(text); // 1 and 0
        String color = isTextOrage ? ORANGE : GOLD;

        for (char ch : text.toCharArray()) {
            System.out.print(color + ch);
            sleepSeconds(charDelaySec);
        }
        System.out.println();
    }

    /**
     * Sleep for a specified number of seconds.
     *
     * @param seconds the number of seconds to sleep
     */
    public void sleepSeconds(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
