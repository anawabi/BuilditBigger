package com.udacity.gradle.builditbigger;

import java.util.Random;

public class Jokes {

    private static final String[] jokes =
            {"An Android app walks into a bar. Bartender asks, Can I get you a drink? The app looks disappointed and says, That was not my intent.",
                    "An Android app walks into a bar. Bartender asks, Can I get you a drink? The app looks disappointed and says, That was not my intent.", "Your first Android app walks into a hotel and asks for a room with an upright bed. \"Why?\" asks the concierge. \"I haven't implemented my horizontal yet\".",
             "A fragment walks into a bar and says, \"I'm lost. Can I please speak to the FragmentManager?\""};
    public static String getJoke(){
        int index = new Random().nextInt(jokes.length);
        return jokes[index];
    }
}
