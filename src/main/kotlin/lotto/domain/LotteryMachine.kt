package lotto.domain

import lotto.infra.port.NumberGenerator

class LotteryMachine(private val numberGenerator: NumberGenerator<LotteryNumberSet>) {

    fun getLotteries(quantity: Int) =
        LotterySet(List(quantity) { Lottery(numberGenerator.generate()) })

    fun getManualLotteries(manualNumberSet: List<LotteryNumberSet>) =
        manualNumberSet
            .map(::Lottery)
            .let(::LotterySet)
}
