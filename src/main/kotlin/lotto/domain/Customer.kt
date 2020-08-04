package lotto.domain

import lotto.domain.value.LottoNumber
import lotto.domain.value.Money
import lotto.domain.value.WinLotto
import lotto.strategy.Strategy
import java.math.BigDecimal

class Customer(private val money: Money, private val strategy: Strategy) {
    val count = (money / PRICE_PER_UNIT).toInt()

    private val lottomarket = LottoMarket(strategy)

    private val lottos = lottomarket.buyLotto(count)

    fun buyLotto() = lottos

    fun winLottoCount(winningNumbers: List<LottoNumber>): List<WinLotto> {
        lottos.forEach {
            it.getWinCount(winningNumbers)
        }
        return WinLotto.resultList()
    }

    fun getTotalRate(): BigDecimal {
        return getTotalMoney() / money.toDouble()
    }

    private fun getTotalMoney(): Money {
        return WinLotto.totalIncome()
    }

    companion object {
        private const val PRICE_PER_UNIT = 1000
    }
}
