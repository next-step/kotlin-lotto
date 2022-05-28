package lotto.ui

import lotto.domain.Lotto

object LotteryRandomGeneratorView {

    fun display(lotteries: List<Lotto>) {
        println("${lotteries.size}개를 구매했습니다.")

        lotteries.forEach { println(it) }
    }
}
