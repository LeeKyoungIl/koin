package com.koinsme.trading.wallet.model;

import com.koinsme.trading.coin.model.Coin;
import com.koinsme.trading.exchange.enums.ExchangeType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Wallet {

    private String password;
    private String walletHash;

    private Map<ExchangeType, Coin> coinMap;

    public Wallet () {

    }

    public void create (String hashCode, String password) {
        this.walletHash = hashCode;
        this.password = password;
    }

    public boolean login () {
        return StringUtils.isNotEmpty(this.walletHash);
    }

    public void inputCoin(Map<ExchangeType, Coin> coinMap) {
        if (coinMap == null) {
            return;
        }
        if (this.coinMap == null) {
            this.coinMap = coinMap;
        } else {
            coinMap.forEach((k, v) -> {
                if (this.coinMap.containsKey(k) == true) {
                    Coin inputCoin = coinMap.get(k);
                    Coin existingCoin = this.coinMap.get(k);
                    existingCoin.plusCoin(inputCoin);

                    this.coinMap.put(k, existingCoin);
                }
            });
        }
    }

    public double getMyCoins() {
        if (this.coinMap == null) {
            return 0.0d;
        }

        return this.coinMap
                .values()
                .stream()
                .mapToDouble(c -> c.getCoinValue())
                .sum();
    }

    public double getMyCoinsByExchange(ExchangeType exchangeType) {
        if (this.coinMap == null) {
            return 0.0d;
        }

        return this.coinMap
                .values()
                .stream()
                .filter(c -> c.getExchangeType() == exchangeType)
                .mapToDouble(c -> c.getCoinValue())
                .sum();
    }

    public boolean exportCoin (Coin exportCoin) {
        if (this.coinMap == null) {
            return false;
        }

        Coin coin = this.coinMap.get(exportCoin.getExchangeType());

        if (coin == null) {
            return false;
        }
        if (coin.getCoinValue() >= exportCoin.getCoinValue()) {
            return coin.minusCoin(exportCoin);
        }
        return false;
    }
}
