package lotto.application

import lotto.domain.Lotto

object LotteryRandomGenerator {

    fun generateLotteryTickets(numberOfTickets: Int): List<Lotto> {
        return List(numberOfTickets) { Lotto(generate()) }
    }

    fun generate(): List<Int> {
        return Lotto.LOTTO_NUMBER_RANGE.shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
    }
}
