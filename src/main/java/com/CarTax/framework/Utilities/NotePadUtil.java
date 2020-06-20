package com.CarTax.framework.Utilities;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Ibi on 19/06/2020.
 */
public class NotePadUtil {

    FileReader fr = null;
    BufferedReader br = null;

    String readLine;
    String filePath;
    StringBuffer sb = new StringBuffer();
    String line;

    private Scanner x;

    public String ReadFile() {
        while (x.hasNext()) {
            String reg = x.next();
            String make = x.next();
            String model = x.next();
            String year = x.next();
        }
        x.close();
        return ReadFile();
    }

    public static void FileReader(String reg) {

        try {
            FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\CarTax\\test\\data\\car_output.txt");
            BufferedReader br = new BufferedReader(fr);
            String i = "";

            while ((i = br.readLine()) != null) {

            }

        } catch (IOException e) {
            System.out.println("Error in saveToFile method");
        }
    }


}
