package lotto.fixture

import lotto.domain.Lottery

class LotteryFixture {

    companion object {
        val MATCH_FOUR_NUMBER_LOTTERY = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_FIRST)
        val MATCH_THREE_NUMBER_LOTTERY = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_SECOND)
        val WINNING_LOTTERY = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_WINNING)
    }
}
