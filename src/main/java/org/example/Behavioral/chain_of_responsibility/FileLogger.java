package org.example.Behavioral.chain_of_responsibility;

public class FileLogger extends Logger {

    public FileLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("File logger: " + msg);
    }
}