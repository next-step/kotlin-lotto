package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

open class SixFortyFiveLottoNumber(open val value: List<SixFortyFiveNumber>) {
    init {
        val hasDuplicatedNumber = value.map { it.value }.distinct().size != value.size
        if (hasDuplicatedNumber) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        fun of(): SixFortyFiveLottoNumber {
            val randomNumberList = mutableListOf<SixFortyFiveNumber>()
            while (randomNumberList.size < LOTTO_NUMBER_COUNT) {
                val sixFortyFiveNumber = SixFortyFiveNumber.of()
                if (randomNumberList.find { it.value == sixFortyFiveNumber.value } == null) {
                    randomNumberList.add(sixFortyFiveNumber)
                }
            }
            return SixFortyFiveLottoNumber(randomNumberList.sortedBy { it.value })
        }
    }
}
