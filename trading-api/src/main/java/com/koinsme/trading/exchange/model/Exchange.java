package com.koinsme.trading.exchange.model;

import com.koinsme.trading.exchange.enums.ExchangeType;

public class Exchange {

    private ExchangeType exchangeType;

    Exchange (ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public ExchangeType getExchangeType () {
        return this.exchangeType;
    }
}
