package com.company;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankParser {

    private final Map<String, Integer> numbersMap = Stream.of(
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

    public Integer parse(List<String> lines) {
        // take first 3 char of each line in lines, append them, add them to numbers
        // take next 3 char in each line in lines and redo
        List<String> numbers = new ArrayList<>();
        int shift = 0;
        while(shift < 27) {
            StringBuilder builder1 = new StringBuilder();
            for(String line : lines) {
                char[] chars = line.toCharArray();
                StringBuilder builder2 = new StringBuilder();
                builder2.append(chars[shift]);
                builder2.append(chars[shift + 1]);
                builder2.append(chars[shift + 2]);
                builder1.append(builder2);
            }
            shift += 3;
            numbers.add(builder1.toString());
        }

        StringBuilder builder = new StringBuilder();
        numbers.forEach(n -> builder.append(this.numbersMap.get(n)));

        return Integer.valueOf(builder.toString());
    }

}
