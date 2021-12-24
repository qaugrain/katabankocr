package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BankValidator {

    public boolean validate(Integer number) {
        char[] num = Integer.toString(number).toCharArray();
        List<Integer> digits = new ArrayList<>();
        for(char c : num) {
            digits.add(Character.getNumericValue(c));
        }
        Collections.reverse(digits);
        return this.add(9, digits) % 11 == 0;
    }

    private int add(int maxMultiplier, List<Integer> digits) {
        if (digits.isEmpty()) return 0;
        return (maxMultiplier * digits.get(digits.size() - 1) + (add(maxMultiplier - 1, digits.stream().limit(digits.size() - 1).collect(Collectors.toList()))));
    }
}
