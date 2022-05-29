package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoSet

class LotteryStore(private val numberGenerator: NumberGenerator<List<Int>>) {

    fun sell(amount: Int): LottoSet<NormalLottery> {
        val count = amount / Lottery.PRICE
        return LottoSet(List(count) { NormalLottery.createRandomNumbers(numberGenerator) })
    }
}
