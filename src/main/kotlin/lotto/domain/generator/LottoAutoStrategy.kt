package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_CACHE
import lotto.domain.LottoNumbers
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
        val lottoNumbers = LOTTO_NUMBER_CACHE
            .map { it.value }
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
            .map { LottoNumber.valueOf(it) }
            .toList()
        return LottoNumbers(lottoNumbers)
    }
}
