package com.janbask.training3;

import java.io.*;
import java.util.Scanner;

public class ObjectInputStreamEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the name of file to read from: ");
        String fileName = in.nextLine();
        try {
            StudentSerializable studentSerializable = deserializeObject(fileName);
            System.out.printf("\nResults\nId: %s\nName: %s", studentSerializable.id, studentSerializable.name);
        }
        catch (ClassNotFoundException classNotFoundException){logException(classNotFoundException);}
        catch (IOException ioException){logException(ioException);}
    }
    static StudentSerializable deserializeObject(String input)
            throws ClassNotFoundException, IOException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(input));
        StudentSerializable s=(StudentSerializable)in.readObject();
        in.close();
        return s;
    }

    static void logException(Exception exception){
        System.err.printf("\nError: %s\nMessage: %s", exception.getClass().getName(), exception.getMessage());
    }
}
