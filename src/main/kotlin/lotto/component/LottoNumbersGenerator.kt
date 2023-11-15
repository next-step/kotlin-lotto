package lotto.component

import lotto.model.LottoNumbers
import lotto.utils.shuffleAndTake

class LottoNumbersGenerator {
    fun generate(lottoNumbersCount: Int): List<LottoNumbers> {
        return (0 until lottoNumbersCount)
            .map { generate() }
    }

    private fun generate(): LottoNumbers {
        val numbers = shuffleAndTake(NUMBER_POOL, LOTTO_NUMBER_LENGTH, sort = true)

        return LottoNumbers(numbers)
    }

    companion object {
        private val NUMBER_POOL = (1..45).toList()
        const val LOTTO_NUMBER_LENGTH = 6
    }
}
