package eu.marrat.adventofcode2025.day01;

import eu.marrat.adventofcode2025.util.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 {

    static void main() {
        System.out.println("hello advent of code 2025");

        Pattern pattern = Pattern.compile("([LR]{1})(\\d+)");

        System.out.println("---");
        int[] ints = Utils.getLines("day01/input.txt")
                .map(pattern::matcher)
                .filter(Matcher::matches)
                .mapToInt(e -> {
                    int multiplier = getMultiplier(e.group(1));
                    int amount = Integer.parseInt(e.group(2));

                    return amount * multiplier;
                })
                .toArray();

        System.out.println(part1(ints));
        System.out.println(part2_stupid(ints));

        System.out.println("---");
    }

    private static int part1(int[] ints) {
        int count = 0;
        int value = 50;

        for (int i : ints) {
            if (i < 0) {
                System.out.format("%3d - %3d = %3d -> ", value, i * -1, value + i);
            } else {
                System.out.format("%3d + %3d = %3d -> ", value, i, value + i);
            }

            value += i;

            while (value < 0) {
                value = 100 + value;
            }

            while (value > 99) {
                value = value - 100;
            }

            System.out.format("%3d%n", value);

            if (value == 0) {
                count++;
            }
        }
        return count;
    }

    private static int part2_stupid(int[] ints) {
        int count = 0;
        int value = 50;

        for (int i : ints) {
            if (i < 0) {
                while (i++ != 0) {
                    value--;

                    if (value == -1) {
                        value = 99;
                    }

                    if (value == 0) {
                        count++;
                    }
                }
            } else if (i > 0) {
                while (i-- != 0) {
                    value++;

                    if (value == 100) {
                        value = 0;
                    }

                    if (value == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static int getMultiplier(String direction) {
        return switch (direction) {
            case "R" -> 1;
            case "L" -> -1;
            case null, default -> throw new RuntimeException("Unknown direction: " + direction);
        };
    }

}
