package lotto.domain

import lotto.domain.value.Money
import lotto.strategy.Strategy

class Customer(private val money: Money, private val strategy: Strategy) {
    val count = money / PRICE_PER_UNIT

    private val lottomarket = LottoMarket(strategy)

    private val lottos = lottomarket.buyLotto(count)

    fun buyLotto() = lottos

    fun getMoney() = money

    fun getTotalMoney(): Money {
        TODO()
    }

    fun getTotalRate(): Double {
        TODO()
    }

    companion object {
        private const val PRICE_PER_UNIT = 1000
    }
}
