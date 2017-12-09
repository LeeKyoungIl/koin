package com.koinsme.trading.exchange

import com.koinsme.trading.exchange.enums.ExchangeType
import com.koinsme.trading.exchange.model.Exchange
import spock.lang.Specification

class ExchangeTest extends Specification {

    def "set Exchange" () {
        setup:
        ExchangeType exchangeType = ExchangeType.valueOf("Bitcoin");

        when:
        Exchange exchange = new Exchange(exchangeType);

        then:
        exchange != null;
        exchange.getExchangeType() == ExchangeType.Bitcoin;
    }
}
