package lotto.application

import lotto.domain.Lotto

object LotteryRandomGenerator {

    fun generateLotteryTickets(numberOfTickets: Int): List<Lotto> {
        return (1..numberOfTickets).map { Lotto(generate()) }
    }

    fun generate(): List<Int> {
        return (1..Lotto.LOTTO_NUMBER_COUNT).map {
            Lotto.LOTTO_NUMBER_RANGE.random()
        }
    }
}
