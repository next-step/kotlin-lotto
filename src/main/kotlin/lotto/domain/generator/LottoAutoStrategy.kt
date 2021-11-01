package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.LottoOperator.LOTTO_FIRST_INDEX
import lotto.domain.LottoOperator.LOTTO_FIRST_NUMBER
import lotto.domain.LottoOperator.LOTTO_LAST_INDEX
import lotto.domain.LottoOperator.LOTTO_LAST_NUMBER

class LottoAutoStrategy : LottoGeneratorStrategy {

    private val lottoNumbers: List<Int> by lazy(
        (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)::toList
    )

    override fun generate(lottoCount: Int): List<Lotto> {
        return (0 until lottoCount)
            .map { generateLottoNumber() }
            .map { Lotto(it) }
            .toList()
    }

    private fun generateLottoNumber(): LottoNumbers {
        val lottoNumbers = lottoNumbers
            .shuffled()
            .subList(LOTTO_FIRST_INDEX, LOTTO_LAST_INDEX)
            .sorted()
            .toList()
        return LottoNumbers(lottoNumbers)
    }
}
