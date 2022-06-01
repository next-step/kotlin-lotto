package lotto.infra

import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet

class LottoNumberGenerator : NumberGenerator<LotteryNumberSet> {

    override fun generate(): LotteryNumberSet =
        LOTTERY_NUMBER_RANGE
            .shuffled()
            .take(LotteryNumberSet.LOTTO_NUMBER_SIZE)
            .map(LotteryNumber::of)
            .let(::LotteryNumberSet)

    companion object {

        private val LOTTERY_NUMBER_RANGE =
            (LotteryNumber.MIN_LOTTO_NUMBER..LotteryNumber.MAX_LOTTO_NUMBER)
    }
}
