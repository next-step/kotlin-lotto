package lotto.infra

import lotto.domain.Lottery
import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumber

class LottoNumberGenerator : NumberGenerator<List<LotteryNumber>> {

    override fun generate(): List<LotteryNumber> =
        LOTTERY_NUMBER_RANGE.shuffled().take(Lottery.LOTTO_NUMBER_LENGTH).map { LotteryNumber(it) }

    companion object {

        private val LOTTERY_NUMBER_RANGE =
            (LotteryNumber.MIN_LOTTO_NUMBER..LotteryNumber.MAX_LOTTO_NUMBER)
    }
}
