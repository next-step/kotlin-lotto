package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode
import lotto.Lotto

class SixFortyFiveLotto(val numbers: List<SixFortyFiveNumber>) : Lotto {

    init {
        val hasDuplicatedNumber = numbers.map { it.value }.distinct().size != numbers.size
        if (hasDuplicatedNumber) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..45)
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun of(): SixFortyFiveLotto {
            val randomNumbers = LOTTO_NUMBER_RANGE
                .map { SixFortyFiveNumber(it) }
                .shuffled()
                .take(LOTTO_NUMBER_COUNT)
                .sortedBy { it.value }
            return SixFortyFiveLotto(randomNumbers)
        }
    }
}
