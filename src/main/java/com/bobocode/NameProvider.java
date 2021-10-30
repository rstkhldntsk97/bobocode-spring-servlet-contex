package com.bobocode;

import org.springframework.stereotype.Component;

@Component
public class NameProvider {

    private static final String NAME = "Rostyslav";

    public String getName() {
        return NAME;
    }

}
