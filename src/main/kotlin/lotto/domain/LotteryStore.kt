package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumberSet
import lotto.vo.LotterySet

class LotteryStore(private val numberGenerator: NumberGenerator<LotteryNumberSet>) {

    fun sell(amount: Int): LotterySet {
        val count = amount / Lottery.PRICE
        return LotterySet(List(count) { Lottery(LotteryNumberSet(numberGenerator.generate())) })
    }
}
