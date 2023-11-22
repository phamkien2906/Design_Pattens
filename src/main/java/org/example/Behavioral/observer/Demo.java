package org.example.Behavioral.observer;

import org.example.Behavioral.observer.editor.Editor;
import org.example.Behavioral.observer.listeners.EmailNotificationListener;
import org.example.Behavioral.observer.listeners.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("open", new EmailNotificationListener("kien@gmail.com"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
