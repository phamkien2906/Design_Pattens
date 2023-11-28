package org.example.Behavioral.visitor;

public interface Visitor {

    void visit(BusinessBook book);

    void visit(DesignPatternBook book);

    void visit(JavaCoreBook book);
}
