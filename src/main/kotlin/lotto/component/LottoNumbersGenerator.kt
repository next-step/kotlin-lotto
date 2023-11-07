package lotto.component

import lotto.model.LottoNumbers

class LottoNumbersGenerator {
    fun generate(): LottoNumbers {
        val numbers = NUMBER_POOL.shuffled()
            .subList(0, LOTTO_NUMBER_LENGTH)
            .sorted()

        return LottoNumbers(numbers)
    }

    companion object {
        private val NUMBER_POOL = (1..45).toList()
        const val LOTTO_NUMBER_LENGTH = 6
    }
}
