package org.example.Structural.flyweight;

public class Soldier implements ISoldier {

    private final String name; // Intrinsic State

    public Soldier(String name) {
        this.name = name;
        System.out.println("Soldier is created! - " + name);
    }

    @Override
    public void promote(Context context) {
        System.out.println(name + " " + context.getId() + " promoted " + context.getStar());
    }
}