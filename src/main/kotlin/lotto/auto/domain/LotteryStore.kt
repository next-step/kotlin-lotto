package lotto.auto.domain

import lotto.auto.infra.port.NumberGenerator
import lotto.auto.vo.LottoSet

class LotteryStore(private val numberGenerator: NumberGenerator) {

    fun sell(amount: Int): LottoSet {
        val count = amount / Lotto.PRICE
        return LottoSet(List(count) { Lotto.createRandomNumbers(numberGenerator) })
    }
}
