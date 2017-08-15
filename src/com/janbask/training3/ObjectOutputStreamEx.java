package com.janbask.training3;

import java.util.Scanner;
import java.io.*;
public class ObjectOutputStreamEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student Data\nId(integer): ");
        int id = Integer.parseInt(in.nextLine());
        System.out.println("Name(String): ");
        String name = in.nextLine();
        System.out.println("\nEnter the name of file to write to: ");
        String fileNameInput = in.nextLine();
        StudentSerializable s1 =new StudentSerializable(id,name);
        try {
            serializeObject(s1, fileNameInput);
        }
        catch (FileNotFoundException fileNotFoundException){logException(fileNotFoundException);}
        catch (IOException ioException){logException(ioException);}
    }

    static void serializeObject(StudentSerializable studentSerializable, String outputFile)
    throws  FileNotFoundException, IOException{
        FileOutputStream fout = new FileOutputStream(outputFile);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(studentSerializable);
        out.flush();
        System.out.println("success");
    }

    static void logException(Exception exception){
        System.err.printf("\nError: %s\nMessage: %s", exception.getClass().getName(), exception.getMessage());
    }
}
