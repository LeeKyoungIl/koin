package com.koinsme.trading.util;

import com.koinsme.trading.coin.model.Coin;
import com.koinsme.trading.exchange.enums.ExchangeType;

import java.util.HashMap;

public class CoinHashMap extends HashMap<ExchangeType, Coin> {

    public CoinHashMap () {
        super();
    }

    @Override
    public Coin put(ExchangeType key, Coin value) {
        Coin coin;

        if (this.containsKey(key) == false) {
            coin = super.put(key, value);
        } else {
            Coin tmpCoin = this.get(key);
            tmpCoin.plusCoin(value);
            coin = super.put(key, tmpCoin);
        }

        return coin;
    }
}
