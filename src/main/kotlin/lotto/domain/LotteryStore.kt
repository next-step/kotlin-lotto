package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoSet

class LotteryStore(private val numberGenerator: NumberGenerator<List<Int>>) {

    fun sell(amount: Int): LottoSet {
        val count = amount / Lottery.PRICE
        return LottoSet(List(count) { Lottery.createRandomNumbers(numberGenerator) })
    }
}
