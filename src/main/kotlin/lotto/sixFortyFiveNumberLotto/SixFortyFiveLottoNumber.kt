package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode
import kotlin.random.Random

open class SixFortyFiveLottoNumber(open val value: List<Int>) {
    init {
        val isInvalidNumberRange = value.any { v -> v < LOTTO_NUMBER_RANGE_START || v > LOTTO_NUMBER_RANGE_END }
        val hasDuplicatedNumber = value.distinct().size != value.size
        if (isInvalidNumberRange || hasDuplicatedNumber) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_RANGE_START = 1
        private const val LOTTO_NUMBER_RANGE_END = 45
        fun of(): SixFortyFiveLottoNumber {
            val randomNumberSet = mutableSetOf<Int>()
            while (randomNumberSet.size < LOTTO_NUMBER_COUNT) {
                val randomNumber = Random.nextInt(
                    LOTTO_NUMBER_RANGE_START,
                    LOTTO_NUMBER_RANGE_END,
                )
                randomNumberSet.add(randomNumber)
            }
            return SixFortyFiveLottoNumber(randomNumberSet.sorted())
        }

        fun validSingleNumber(number: Int): Boolean {
            return number in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END
        }
    }
}
