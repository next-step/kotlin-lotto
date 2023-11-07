package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.strategy.DrawStrategy

class AutoStrategy : DrawStrategy {

    override fun draw(): Lotto {
        val lottoNumbers = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER).toList().shuffled()
        return Lotto(lottoNumbers.take(LOTTO_NUMBER_COUNT).sorted())
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
