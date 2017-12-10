package com.koinsme.trading.wallet.model;

import com.koinsme.trading.coin.model.Coin;
import com.koinsme.trading.exchange.enums.ExchangeType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Wallet {

    private String password;
    private String walletHash;

    private Map<Coin> coinMap;

    public Wallet () {

    }

    public void create (String hashCode, String password) {
        this.walletHash = hashCode;
        this.password = password;
    }

    public boolean login () {
        return StringUtils.isNotEmpty(this.walletHash);
    }

    public void inputCoin(List<Coin> coins) {
        if (CollectionUtils.isEmpty(coins) == true) {
            return;
        }
        if (CollectionUtils.isEmpty(this.coins) == true) {
            this.coins = coins;
        } else {
            this.coins.addAll(coins);
        }
    }

    public double getMyCoins() {
        if (CollectionUtils.isEmpty(this.coins) == true) {
            return 0.0d;
        }

        return this.coins.stream()
                .filter(c -> c.getCoinValue() > 0.0f)
                .mapToDouble(c -> c.getCoinValue())
                .sum();
    }

    public double getMyCoinsByExchange(ExchangeType exchangeType) {
        if (CollectionUtils.isEmpty(this.coins) == true) {
            return 0.0d;
        }

        return this.coins.stream()
                .filter(c -> c.getCoinValue() > 0.0f)
                .filter(c -> c.getExchangeType() == exchangeType)
                .mapToDouble(c -> c.getCoinValue())
                .sum();
    }

    public double exportCoin(ExchangeType exchangeType, double coinValue) {
        if (CollectionUtils.isEmpty(this.coins) == true) {
            return 0.0d;
        }

        if () {

        }
    }
}
