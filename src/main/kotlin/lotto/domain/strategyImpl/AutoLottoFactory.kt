package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.strategy.DrawStrategy

class AutoLottoFactory : DrawStrategy {

    override fun draw(): Lotto {
        val shuffledNumbers = LottoNumber.lottoNumberRange.shuffled().take(Lotto.LOTTO_NUMBER_COUNT)
        return Lotto(shuffledNumbers.map { LottoNumber(it) })
    }
}
