package lotto.dto

import lotto.dto.LottoNumbers.Companion.LOTTO_NUMBER_COUNT
import lotto.dto.LottoNumbers.Companion.LOTTO_NUMBER_RANGE

object LottoNumberGenerator {

    fun generate(): LottoNumbers {
        val numbers = mutableListOf<Int>()
        while (numbers.size < LOTTO_NUMBER_COUNT) {
            val number = getRandomNumber()
            if (!numbers.contains(number)) {
                numbers.add(number)
            }
        }

        return LottoNumbers(numbers.shuffled())
    }

    private fun getRandomNumber() = LOTTO_NUMBER_RANGE.random()
}
