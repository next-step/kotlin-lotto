package lotto.domain.strategy

import lotto.domain.Lotto
import lotto.domain.Lottos

class LottoAutoGeneratorStrategy : LottoGeneratorStrategy {

    private val lottoNumbers = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER).toList()

    override fun generate(lottoCount: Int): Lottos {
        return Lottos(List(lottoCount) { generateLottoNumber() })
    }

    private fun generateLottoNumber(): Lotto {
        val lottoNumbers = lottoNumbers
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
        return Lotto(lottoNumbers)
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val LOTTO_FIRST_INDEX = 0
        private const val LOTTO_LAST_INDEX = 6
    }
}
