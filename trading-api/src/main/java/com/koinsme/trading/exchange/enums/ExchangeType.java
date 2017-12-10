package com.koinsme.trading.exchange.enums;

public enum ExchangeType {

    Bitcoin("Bitcoin", true),
    Bitcoincash("Bitcoincash", true);

    private String label;
    private boolean isActive;

    ExchangeType (String label, boolean isActive) {
        this.label = label;
        this.isActive = isActive;
    }
}
