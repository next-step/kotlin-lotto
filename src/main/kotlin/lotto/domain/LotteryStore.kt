package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoSet

class LotteryStore(private val numberGenerator: NumberGenerator) {

    fun sell(amount: Int): LottoSet {
        val count = amount / Lotto.PRICE
        return LottoSet(List(count) { Lotto.createRandomNumbers(numberGenerator) })
    }
}
