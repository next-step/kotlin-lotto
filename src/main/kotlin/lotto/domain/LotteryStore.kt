package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet
import lotto.vo.LotterySet

class LotteryStore(private val numberGenerator: NumberGenerator<LotteryNumberSet>) {

    fun sell(amount: Int): LotterySet {
        val count = amount / Lottery.PRICE
        return LotterySet(List(count) { Lottery(LotteryNumberSet(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of))) })
    }
}
