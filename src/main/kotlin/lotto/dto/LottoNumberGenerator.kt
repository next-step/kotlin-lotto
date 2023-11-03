package lotto.dto

import lotto.utils.LOTTO_NUMBER_COUNT
import lotto.utils.LOTTO_NUMBER_RANGE

object LottoNumberGenerator {

    fun generate(): LottoNumber {
        val numbers = mutableListOf<Int>()
        while (numbers.size < LOTTO_NUMBER_COUNT) {
            val number = getRandomNumber()
            if (!numbers.contains(number)) {
                numbers.add(number)
            }
        }

        return LottoNumber(numbers.shuffled())
    }

    private fun getRandomNumber() = LOTTO_NUMBER_RANGE.random()
}
