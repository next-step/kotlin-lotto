package lotto.fixture

import lotto.domain.Lotteries

class LotteriesFixture {

    companion object {
        val LOTTERIES =
            Lotteries.of(listOf(LotteryFixture.MATCH_THREE_NUMBER_LOTTERY, LotteryFixture.MATCH_FOUR_NUMBER_LOTTERY))
    }
}
