package lotto.infrastructure

import lotto.domain.LottoBallMachine
import lotto.domain.LottoBalls
import lotto.domain.LottoLine

class RandomLottoBallMachine : LottoBallMachine {
    override fun generate(): LottoLine {
        val lottoBalls =
            LottoBalls.CASHED_LOTTO_BALLS
                .extractRandomLottoBalls(LottoLine.LOTTO_BALLS_SIZE)
        return LottoLine(lottoBalls)
    }
}
