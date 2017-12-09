package com.koinsme.trading.coin.model;

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
}
