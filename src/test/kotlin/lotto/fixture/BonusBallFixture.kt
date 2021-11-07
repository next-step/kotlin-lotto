package lotto.fixture

import lotto.domain.BonusBall
import lotto.domain.LottoNumber

class BonusBallFixture {

    companion object {
        val BONUS_BALL = BonusBall.of(WinningLotteryFixture.WINNING_LOTTERY, LottoNumberFixture.TWENTY_THREE)
    }
}
