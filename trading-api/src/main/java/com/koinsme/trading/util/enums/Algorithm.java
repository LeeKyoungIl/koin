package com.koinsme.trading.util.enums;

public enum Algorithm {

    SHA_256("SHA-256"),
    MD5("MD5");

    private String algorithm;

    Algorithm (String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm () {
        return this.algorithm;
    }
}
