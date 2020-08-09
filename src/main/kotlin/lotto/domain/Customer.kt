package lotto.domain

import lotto.domain.value.HitLotto
import lotto.domain.value.LottoNumber
import lotto.domain.value.Money
import lotto.strategy.Strategy
import java.math.BigDecimal

class Customer(private val money: Money, private val strategy: Strategy) {
    val count = (money / PRICE_PER_UNIT).toInt()

    private val lottomarket = LottoMarket(strategy)

    private val lottos = lottomarket.buyLotto(count)

    private val winLotto = HitLotto

    fun buyLotto() = lottos

    fun hitLottos(winningNumbers: List<LottoNumber>): List<HitLotto> {
        return lottos.map {
            it.hitLotto(winningNumbers)
        }
    }

    fun countLottos(hitLottos: List<HitLotto>): List<HitLotto> {
        winLotto.resetCount()
        hitLottos.forEach {
            it.plusCount()
        }
        return HitLotto.resultList()
    }

    fun getTotalRate(): BigDecimal {
        return getTotalMoney() / money.toDouble()
    }

    private fun getTotalMoney(): Money {
        return HitLotto.totalIncome()
    }

    companion object {
        private const val PRICE_PER_UNIT = 1000
    }
}
