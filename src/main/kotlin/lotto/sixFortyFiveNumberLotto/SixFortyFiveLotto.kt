package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode
import lotto.Lotto

class SixFortyFiveLotto(val numbers: List<SixFortyFiveNumber>) :
    Lotto<SixFortyFiveWinningLotto, SixFortyFiveLottoWinningResult> {

    init {
        val hasDuplicatedNumber = numbers.map { it.value }.distinct().size != numbers.size
        if (hasDuplicatedNumber) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    override fun checkWinning(winningValue: SixFortyFiveWinningLotto): SixFortyFiveLottoWinningResult {
        return SixFortyFiveLottoWinningResult.of(numbers, winningValue)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun of(): SixFortyFiveLotto {
            val randomNumberList = mutableListOf<SixFortyFiveNumber>()
            while (randomNumberList.size < LOTTO_NUMBER_COUNT) {
                val sixFortyFiveNumber = SixFortyFiveNumber.of()
                if (randomNumberList.find { it.value == sixFortyFiveNumber.value } == null) {
                    randomNumberList.add(sixFortyFiveNumber)
                }
            }
            return SixFortyFiveLotto(randomNumberList.sortedBy { it.value })
        }
    }
}
