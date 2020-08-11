package lotto.model.lotto

import lotto.model.generator.LottoNumberGenerator
import lotto.model.generator.RandomNumberGenerator

data class Lotto(
    private val generator: LottoNumberGenerator = RandomNumberGenerator
) {
    private val numbers: Numbers = generator.generate()

    override fun toString(): String {
        return numbers.list.toString()
    }

    fun checkNumbers(winningNumbers: WinnerNumbers) = winningNumbers.match(numbers)

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val LOTTO_RANGE = MIN_NUMBER..MAX_NUMBER
        const val NUMBER_COUNT = 6

        fun newAutoInstance(generator: LottoNumberGenerator = RandomNumberGenerator) =
            Lotto(generator)
    }
}
