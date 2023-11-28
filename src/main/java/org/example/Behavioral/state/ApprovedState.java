package org.example.Behavioral.state;

public class ApprovedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Approved");
    }
}