package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto

object LotteryRandomGenerator {

    fun generateLotteryTickets(numberOfTickets: Int): Lotteries {
        return Lotteries(numberOfTickets, this::generate)
    }

    fun generate(): List<Int> {
        return Lotto.LOTTO_NUMBER_RANGE.shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
    }
}
