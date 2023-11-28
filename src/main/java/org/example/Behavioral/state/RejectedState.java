package org.example.Behavioral.state;

public class RejectedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Rejected");
    }
}
