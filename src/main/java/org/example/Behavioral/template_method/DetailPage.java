package org.example.Behavioral.template_method;

public class DetailPage extends PageTemplate {

    @Override
    protected void showBody() {
        System.out.println("Content of detail");
    }
}
