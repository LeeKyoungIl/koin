package com.koinsme.trading.wallet

import com.koinsme.trading.coin.model.Coin
import com.koinsme.trading.exchange.enums.ExchangeType
import com.koinsme.trading.exchange.model.Exchange
import com.koinsme.trading.util.WalletUtils
import com.koinsme.trading.wallet.model.Wallet
import spock.lang.Specification

class WalletTest extends Specification {

    def "make wallet" () {
        setup:
        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        then:
        wallet.login() == true;
    }

    def "set coin" () {
        setup:
        List<Coin> myCoins = new ArrayList<>();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        Exchange exchange = new Exchange(exchangeType);
        double coinValue = 1.2d;
        Coin coin = new Coin(exchange);
        coin.init(coinValue);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.add(coin);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoins() == 1.2d;
    }

    def "set coins" () {
        setup:
        List<Coin> myCoins = new ArrayList<>();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        Exchange exchange = new Exchange(exchangeType);
        double coinValue = 1.2d;
        Coin coin = new Coin(exchange);
        coin.init(coinValue);

        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchange);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.add(coin)
        myCoins.add(coin1);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoins() == 1.4d;
    }

    def "set coins with list" () {
        setup:
        List<Coin> myCoins = new ArrayList<>();
        List<Coin> myCoins1 = new ArrayList<>();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        Exchange exchange = new Exchange(exchangeType);
        double coinValue = 1.2d;
        Coin coin = new Coin(exchange);
        coin.init(coinValue);

        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchange);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.add(coin)
        myCoins1.add(coin1);

        wallet.inputCoin(myCoins);
        wallet.inputCoin(myCoins1);

        then:
        wallet.getMyCoins() == 1.4d;
    }
}
