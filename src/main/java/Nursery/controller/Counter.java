package Nursery.controller;

import java.io.Closeable;

public class Counter implements Closeable {
    private Integer counter = 0;

    public Counter() {
        open();
    }
    public void add() throws NullPointerException {
        counter += 1;
    }

    public void open() {

    }

    @Override
    public void close() {
    }

    @Override
    public String toString() {
        return "{" + counter + "pc(s)} animals added in list";
    }
}
