package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream input = Main.class.getClassLoader().getResourceAsStream("file.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        List<String> list = new ArrayList<>();
        while(reader.ready()) {
            String line = reader.readLine();
            list.add(line);
        }

        BankParser bankParser = new BankParser();
        Integer number = bankParser.parse(list);
        System.out.println(number);

        BankValidator bankValidator = new BankValidator();
        System.out.println(bankValidator.validate(number));

        System.out.println(bankValidator.validate(345882865));
    }
}
