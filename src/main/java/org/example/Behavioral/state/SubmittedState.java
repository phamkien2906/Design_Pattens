package org.example.Behavioral.state;

public class SubmittedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Submitted");
    }
}
