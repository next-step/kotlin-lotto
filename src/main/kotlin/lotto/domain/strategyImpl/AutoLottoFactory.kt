package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.strategy.DrawStrategy

class AutoLottoFactory : DrawStrategy {

    override fun draw(): Lotto {
        val lottoNumbers = lottoNumberRange.toList().shuffled()
        return Lotto(lottoNumbers.take(LOTTO_NUMBER_COUNT).sorted())
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
        private val lottoNumberRange: IntRange = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
    }
}
