package lotto.ui

import lotto.application.LotteryRandomGenerator
import lotto.domain.Lotto

object LotteryRandomGeneratorView {

    fun display(numberOfTickets: Int): List<Lotto> {
        println("${numberOfTickets}개를 구매했습니다.")
        val lotteries = LotteryRandomGenerator.generateLotteryTickets(numberOfTickets)

        lotteries.forEach { println(it) }
        return lotteries
    }
}
