package lotto.util

import lotto.dto.LottoNumbers

object RandomNumbers : AutoNumbers {
    private const val BOUND = 45
    private const val SIZE = 6
    private val LOTTO_NUMBERS: List<Int> = List(BOUND) { it + 1 }

    override fun generateNumbers(): LottoNumbers {
        return LottoNumbers(LOTTO_NUMBERS.shuffled().take(SIZE))
    }
}
