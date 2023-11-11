package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.strategy.DrawStrategy

class AutoLottoFactory : DrawStrategy {

    override fun draw(): Lotto {
        val lottoNumbers = lottoNumberRange.toList().shuffled()
        val sortedLotto = lottoNumbers.take(LOTTO_NUMBER_COUNT).sorted()
        sortedLotto.map { LottoNumber(it) }

        return Lotto(sortedLotto)
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private val lottoNumberRange: IntRange = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
