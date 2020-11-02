package com.CarTax.framework.Utilities;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Ibi on 01/11/2020.
 */
public class ReadFileToString {

    //Read file content into the string with - Files.lines(Path path, Charset cs)

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static String ExtractRegistrationNumberFromTheFile(String regN) {

        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_input.txt";
        String str1 = readLineByLineJava8(filePath);

        String regex = regN;
        Pattern p = Pattern.compile(regex);

        Matcher matcher = p.matcher(str1);
        while (matcher.find())
        {
            matcher.group();
            break;
        }

        return matcher.group().trim();

    }


}
