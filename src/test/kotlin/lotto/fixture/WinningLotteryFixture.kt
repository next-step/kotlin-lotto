package lotto.fixture

import lotto.domain.WinningLottery

class WinningLotteryFixture {

    companion object {
        val WINNING_LOTTERY = WinningLottery.of(listOf(1, 2, 3, 4, 5, 6))
    }
}
