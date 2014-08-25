package com.teamtreehouse.funfacts;

import java.util.Random;

/**
 * Created by pietro on 25/08/14.
 */
public class FactBook  {
    public String[] mfacts = {"Non è più come una volta",
            "Piove governo ladro",
            "Non ci sono più le mezze stagioni"};
    public String getfact() {



        String fact;
        Random randomgenerator = new Random();
        int randomnumber = randomgenerator.nextInt(mfacts.length);
        fact= mfacts[randomnumber];
        return fact;

    }

}
