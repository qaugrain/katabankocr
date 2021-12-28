package com.company;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankParser {

    private static final Map<String, Integer> numbersMap = Stream.of(
                    new AbstractMap.SimpleImmutableEntry<>("     |  |", 1),
                    new AbstractMap.SimpleImmutableEntry<>(" _  _||_ ", 2),
                    new AbstractMap.SimpleImmutableEntry<>(" _  _| _|", 3),
                    new AbstractMap.SimpleImmutableEntry<>("   |_|  |", 4),
                    new AbstractMap.SimpleImmutableEntry<>(" _ |_  _|", 5),
                    new AbstractMap.SimpleImmutableEntry<>(" _ |_ |_|", 6),
                    new AbstractMap.SimpleImmutableEntry<>(" _   |  |", 7),
                    new AbstractMap.SimpleImmutableEntry<>(" _ |_||_|", 8),
                    new AbstractMap.SimpleImmutableEntry<>(" _ |_| _|", 9))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private BankParser() {
        throw new IllegalStateException("Utility class");
    }

    public static Integer parse(List<String> lines) {
        // take first 3 char of each line in lines, append them, add them to numbers
        // take next 3 char in each line in lines and redo
        List<String> numbers = new ArrayList<>();
        int shift = 0;
        while(shift < 27) {
            StringBuilder numBuilder = new StringBuilder();
            for(String line : lines) {
                char[] chars = line.toCharArray();
                StringBuilder digitBuilder = new StringBuilder();
                digitBuilder.append(chars[shift]);
                digitBuilder.append(chars[shift + 1]);
                digitBuilder.append(chars[shift + 2]);
                numBuilder.append(digitBuilder);
            }
            shift += 3;
            numbers.add(numBuilder.toString());
        }

        StringBuilder builder = new StringBuilder();
        numbers.forEach(n -> builder.append(numbersMap.get(n)));

        return Integer.valueOf(builder.toString());
    }

}
