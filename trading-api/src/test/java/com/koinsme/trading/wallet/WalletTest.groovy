package com.koinsme.trading.wallet

import com.koinsme.trading.coin.model.Coin
import com.koinsme.trading.exchange.enums.ExchangeType
import com.koinsme.trading.exchange.model.Exchange
import com.koinsme.trading.util.CoinHashMap
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
        Map myCoins = new CoinHashMap();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        double coinValue = 1.2d;
        Coin coin = new Coin(exchangeType);
        coin.init(coinValue);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.put(exchangeType, coin);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoins() == 1.2d;
    }

    def "set coins" () {
        setup:
        Map myCoins = new CoinHashMap();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        double coinValue = 1.2d;
        Coin coin = new Coin(exchangeType);
        coin.init(coinValue);

        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchangeType);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.put(exchangeType, coin);
        myCoins.put(exchangeType, coin1);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoins() == 1.4d;
    }

    def "set coins with list" () {
        setup:
        Map myCoins = new CoinHashMap();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        double coinValue = 1.2d;
        Coin coin = new Coin(exchangeType);
        coin.init(coinValue);

        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchangeType);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.put(exchangeType, coin);
        myCoins.put(exchangeType, coin1);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoins() == 1.4d;
    }

    def "set coins by exchange" () {
        setup:
        Map myCoins = new CoinHashMap();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        double coinValue = 1.2d;
        Coin coin = new Coin(exchangeType);
        coin.init(coinValue);

        ExchangeType exchangeType1 = ExchangeType.valueOf("Bitcoincash");
        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchangeType1);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.put(exchangeType, coin);
        myCoins.put(exchangeType1, coin1);

        wallet.inputCoin(myCoins);

        then:
        wallet.getMyCoinsByExchange(exchangeType) == 1.2d;
        wallet.getMyCoinsByExchange(exchangeType1) == 0.2d;
    }

    def "export coins by exchange" () {
        setup:
        Map myCoins = new CoinHashMap();

        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");
        double coinValue = 1.2d;
        Coin coin = new Coin(exchangeType);
        coin.init(coinValue);

        ExchangeType exchangeType1 = ExchangeType.valueOf("Bitcoincash");
        double coinValue1 = 0.2d;
        Coin coin1 = new Coin(exchangeType1);
        coin1.init(coinValue1);

        String email = "leekyoungil@gmail.com";
        String password = "lki1234";
        String walletHash = WalletUtils.generateWalletHashValue(email);
        String walletPassword = WalletUtils.generatePasswod(password);

        double exportCoinValue = 0.002d;
        Coin exportCoin = new Coin(exchangeType);
        exportCoin.init(exportCoinValue);

        when:
        Wallet wallet = new Wallet();
        wallet.create(walletHash, walletPassword);

        myCoins.put(exchangeType, coin);
        myCoins.put(exchangeType1, coin1);

        wallet.inputCoin(myCoins);

        boolean exportResult = wallet.exportCoin(exportCoin);

        then:
        exportResult == true;
        wallet.getMyCoinsByExchange(ExchangeType.Bitcoin) == 1.198d;
        wallet.getMyCoinsByExchange(ExchangeType.Bitcoincash) == 0.2d;
    }
}
