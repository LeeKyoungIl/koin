package com.koinsme.trading.wallet.model;

import com.koinsme.trading.coin.model.Coin;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Wallet {

    private String password;
    private String walletHash;

    private List<Coin> coins;

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
            return 0.0f;
        }

        return this.coins.stream()
                .filter(c -> c.getCoinValue() > 0.0f)
                .mapToDouble(c -> c.getCoinValue())
                .sum();
    }
}
