package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFileName = "file_ERR";
        InputStream input = Main.class.getClassLoader().getResourceAsStream(inputFileName + ".txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        List<String> list = new ArrayList<>();
        while(reader.ready()) {
            String line = reader.readLine();
            list.add(line);
        }

        String number = BankParser.parse(list);
        BankValidator bankValidator = new BankValidator();

        StringBuilder b = new StringBuilder();
        if(number.contains("?")) {
            b.append(number);
            b.append(" ");
            b.append("ILL");
        } else if(bankValidator.validate(number)) {
            b.append(number);
        } else {
            b.append(number);
            b.append(" ");
            b.append("ERR");
        }

        String resultFileName = "C:\\Users\\qaugrain\\Desktop\\KATA\\BankOCR\\" + inputFileName + "_result.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName, true));
        writer.append(b);
        writer.close();
    }
}
