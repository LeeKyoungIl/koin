package com.koinsme.trading.coin.model;

import com.koinsme.trading.exchange.enums.ExchangeType;
import com.koinsme.trading.exchange.model.Exchange;

public class Coin {

    private Exchange exchange;
    private double coinValue = 0.0d;

    public Coin (Exchange exchange) {
        this.exchange = exchange;
    }

    public void init(double coinValue) {
        this.coinValue = coinValue;
    }

    public double getCoinValue () {
        return this.coinValue;
    }

    public ExchangeType getExchangeType () {
        if (this.exchange == null) {
            return null;
        }
        return this.exchange.getExchangeType();
    }
}
