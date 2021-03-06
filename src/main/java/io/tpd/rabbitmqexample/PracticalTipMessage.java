package io.tpd.rabbitmqexample;

import java.io.Serializable;

public class PracticalTipMessage implements Serializable {

    private final String text;
    private final int priority;
    private final boolean secret;

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "PracticalTipMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }

    public PracticalTipMessage(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;


    }
}
