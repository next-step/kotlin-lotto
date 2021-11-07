package lotto.domain.strategy

import lotto.domain.Lottery
import lotto.fixture.LotteryFixture

object MockLottoGenerator : LottoGenerator {

    override fun generate(): Lottery {
        return LotteryFixture.WINNING_LOTTERY
    }
}
