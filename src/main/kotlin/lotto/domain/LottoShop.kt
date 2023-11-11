package lotto.domain

import lotto.domain.strategy.DrawStrategy
import lotto.domain.strategyImpl.AutoLottoFactory
import lotto.error.ErrorMessage.MIN_LOTTO_COUNT

class LottoShop(private val drawStrategy: DrawStrategy = AutoLottoFactory()) {

    fun getLottoBuyCount(money: Int): Int {
        val lottoBuyCount = money.div(LOTTO_PRICE)
        require(lottoBuyCount > 0) { MIN_LOTTO_COUNT.message }
        return lottoBuyCount
    }

    fun buyLotto(lottoBuyCount: Int): List<Lotto> = List(lottoBuyCount) { drawStrategy.draw() }

    fun getJackpotNumbers(inputNumber: String, delimiters: String = ", "): Lotto {
        return Lotto(inputNumber.split(delimiters).map { it.toInt() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
