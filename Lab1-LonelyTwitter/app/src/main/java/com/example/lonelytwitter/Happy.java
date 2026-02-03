package com.example.lonelytwitter;

import java.util.Date;

public class Happy extends CurrentMood {
    public Happy() {
    }

    public Happy(Date date) {
        super(date);
    }

    @Override
    public String displayMood() {
        return "Happy";
    }
}
