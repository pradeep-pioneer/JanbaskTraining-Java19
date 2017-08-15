package com.janbask.training3;
import java.io.Serializable;

public class StudentSerializable implements Serializable {
    int id;
    String name;
    public StudentSerializable(){
        id=-1;
        name="Unknowm";
    }
    public StudentSerializable(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
