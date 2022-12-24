package lotto.domain.vo

import lotto.domain.enums.Prize

class LotteryNumbers(
    val lotteryNumbers: List<LotteryNumber>
) {
    init {
        require(lotteryNumbers.size == LOTTERY_NUMBER_SIZE) { "로또의 추첨 번호는 ${LOTTERY_NUMBER_SIZE}개입니다." }
    }

    fun contains(lotteryNumber: LotteryNumber): Boolean = this.lotteryNumbers.contains(lotteryNumber)

    override fun toString(): String {
        return "[${this.lotteryNumbers.joinToString(separator = ",") { it.toString() }}]"
    }

    fun findPrize(targetLotteryNumbers: LotteryNumbers, bonusNumber: LotteryNumber): Prize {
        val countEqualLotteryNumbers = countEqualLotteryNumbers(targetLotteryNumbers)
        val hasBonusNumber = hasBonusNumber(bonusNumber)
        return Prize.find(countEqualLotteryNumbers.toLong(), hasBonusNumber)
    }

    private fun countEqualLotteryNumbers(targetLotteryNumbers: LotteryNumbers): Int {
        return this.lotteryNumbers.filter {
            targetLotteryNumbers.contains(it)
        }.size
    }

    private fun hasBonusNumber(bonusNumber: LotteryNumber): Boolean {
        return this.lotteryNumbers.find { it.value == bonusNumber.value } != null
    }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
    }
}
