package com.company;

public class Compito {
    protected int id;
    private static int nextId= 0;

    public Compito(){
        this.id=nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return "Compito{" +
                "id=" + id +
                '}';
    }
}
