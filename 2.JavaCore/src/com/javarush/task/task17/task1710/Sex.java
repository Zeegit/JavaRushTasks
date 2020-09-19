package com.javarush.task.task17.task1710;

public enum Sex {
    MALE("м"),
    FEMALE("ж");

    private final String sex;

    Sex(String m) {
        this.sex = m;
    }

    @Override
    public String toString() {
        return sex;
    }
}
