package com.koinsme.trading.coin.model;

import com.koinsme.trading.exchange.enums.ExchangeType;
import com.koinsme.trading.exchange.model.Exchange;

public class Coin {

    private ExchangeType exchangetype;
    private double coinValue = 0.0d;

    public Coin (ExchangeType exchangetype) {
        this.exchangetype = exchangetype;
    }

    public void init(double coinValue) {
        this.coinValue = coinValue;
    }

    public double getCoinValue () {
        return this.coinValue;
    }

    public ExchangeType getExchangeType () {
        if (this.exchangetype == null) {
            return null;
        }
        return this.exchangetype;
    }

    public void plusCoin (Coin coin) {
        this.coinValue += coin.getCoinValue();
    }

    public boolean minusCoin (Coin coin) {
        if (this.coinValue >= coin.getCoinValue()) {
            this.coinValue -= coin.getCoinValue();
            return true;
        }

        return false;
    }
}
