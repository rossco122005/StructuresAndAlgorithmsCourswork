/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.courseworkstep1;
import java.io.*;
/**
 *
 * @author Ross
 */
public class Input {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static Character getCharacter(String prompt) {
        Character value;
        System.out.println(prompt);
        try {
            value = Input.input.readLine().charAt(0);
        } catch (Exception error) {
            // error condition
            value = null;
        }
        return value;
    }

    public static Double getDouble(String prompt) {
        Double value;
        System.out.println(prompt);
        try {
            value = Double.parseDouble(Input.input.readLine());
        } catch (Exception error) {
            // error condition
            throw new NumberFormatException();
        }
        return value;
    }

    public static Integer getInteger(String prompt) {
        Integer value;
        System.out.println(prompt);
        try {
            value = Integer.parseInt(Input.input.readLine());
        } catch (Exception error) {
            // error condition
            throw new NumberFormatException();
        }
        return value;
    }

    public static String getString(String prompt) {
        String string;
        System.out.println(prompt);
        try {
            string = Input.input.readLine();
        } catch (Exception error) {
            // error condition
            string = null;
        }
        return string;
    }
}
