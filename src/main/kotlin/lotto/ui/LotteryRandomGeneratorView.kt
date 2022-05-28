package lotto.ui

import lotto.domain.Lotteries

object LotteryRandomGeneratorView {

    fun display(lotteries: Lotteries) {
        println("${lotteries.count()}개를 구매했습니다.")

        lotteries.forEach { println(it) }
    }
}
