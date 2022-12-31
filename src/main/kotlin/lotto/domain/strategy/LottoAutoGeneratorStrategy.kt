package lotto.domain.strategy

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoAutoGeneratorStrategy : LottoGeneratorStrategy {

    private val lottoNumbers = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER).toList()

    override fun generate(lottoCount: Int): Lotto {
        return Lotto(
            (0 until lottoCount)
                .map { generateLottoNumber() }
                .toList()
        )
    }

    private fun generateLottoNumber(): LottoNumber {
        val lottoNumbers = lottoNumbers
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
            .toList()
        return LottoNumber(lottoNumbers)
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private const val LOTTO_FIRST_INDEX = 0
        private const val LOTTO_LAST_INDEX = 6
    }
}
