package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBERS
import lotto.domain.generator.LottoGeneratorStrategy.Companion.LOTTO_FIRST_INDEX
import lotto.domain.generator.LottoGeneratorStrategy.Companion.LOTTO_LAST_INDEX

class LottoAutoStrategy : LottoGeneratorStrategy {

    override fun generate(lottoCount: Int): List<Lotto> {
        return (0 until lottoCount)
            .map { generateLottoNumber() }
            .map { Lotto(it) }
            .toList()
    }

    private fun generateLottoNumber(): LottoNumbers {
        val lottoNumbers = LOTTO_NUMBERS
            .map { it.value }
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
            .map { LottoNumber(it) }
            .toList()
        return LottoNumbers(lottoNumbers)
    }
}
