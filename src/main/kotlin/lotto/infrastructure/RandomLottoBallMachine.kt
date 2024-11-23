package lotto.infrastructure

import lotto.domain.LottoBallMachine
import lotto.domain.LottoBalls
import lotto.domain.LottoLine

class RandomLottoBallMachine : LottoBallMachine {
    override fun generate(): LottoLine {
        LottoBalls.LOTTO_BALLS.shuffled().let {
            return LottoLine(it.subList(0, 6))
        }
    }
}
