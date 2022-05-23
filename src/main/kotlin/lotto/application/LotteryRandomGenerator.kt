package lotto.application

import lotto.domain.Lotto

object LotteryRandomGenerator {

    fun generateLotteryTickets(numberOfTickets: Int): List<Lotto> {
        return (1..numberOfTickets).map { Lotto(generate()) }
    }

    fun generate(): List<Int> {
        return Lotto.LOTTO_NUMBER_RANGE.shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
    }
}
