package lotto.domain

import lotto.vo.LotteryNumber

data class LotteryNumberSet(
    private val lotteryNumbers: List<LotteryNumber>
) : List<LotteryNumber> by lotteryNumbers {

    init {
        require(lotteryNumbers.size == LOTTO_NUMBER_SIZE)
    }

    override fun toString() = "${lotteryNumbers.sortedBy { it }}"

    companion object {

        const val LOTTO_NUMBER_SIZE = 6
    }
}
