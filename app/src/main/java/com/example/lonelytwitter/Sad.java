package com.example.lonelytwitter;

import java.util.Date;

public class Sad extends CurrentMood {
    public Sad() {
    }

    public Sad(Date date) {
        super(date);
    }

    @Override
    public String displayMood() {
        return "Sad";
    }
}
