package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode
import lotto.Lotto

class SixFortyFiveLotto(val numbers: List<SixFortyFiveNumber>) : Lotto {

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER_COUNT.msg }
        val hasDuplicatedNumber = numbers.map { it.value }.distinct().size != numbers.size
        require(!hasDuplicatedNumber) { ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER_DUPLICATE.msg }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..45)
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun ofAuto(): SixFortyFiveLotto {
            val numbers = LOTTO_NUMBER_RANGE
                .map { SixFortyFiveNumber(it) }
                .shuffled()
                .take(LOTTO_NUMBER_COUNT)
                .sortedBy { it.value }
            return SixFortyFiveLotto(numbers)
        }
    }
}
