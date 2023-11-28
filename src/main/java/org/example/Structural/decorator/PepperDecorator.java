package org.example.Structural.decorator;

public class PepperDecorator extends PizzaDecorator {

    public PepperDecorator(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String doPizza() {
        String type = mPizza.doPizza();
        return type + addPepper();
    }

    // This is our additional functionality
    // It add pepper to existing pizza at runtime
    private String addPepper() {
        return "+ Pepper";
    }
}
