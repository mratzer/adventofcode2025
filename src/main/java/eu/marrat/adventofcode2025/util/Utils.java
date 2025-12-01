package eu.marrat.adventofcode2025.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Utils {

    public static Stream<String> getLines(String filename) {
        try {
            return Files.lines(Path.of(ClassLoader.getSystemResource(filename).toURI()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] toIntArray(String[] strings) {
        int[] ints = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }

        return ints;
    }

    public static long[] toLongArray(String[] strings) {
        long[] longs = new long[strings.length];

        for (int i = 0; i < strings.length; i++) {
            longs[i] = Long.parseLong(strings[i]);
        }

        return longs;
    }

    private Utils() {
    }
}
