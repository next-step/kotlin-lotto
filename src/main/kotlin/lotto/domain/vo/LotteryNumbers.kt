package lotto.domain.vo

import lotto.domain.enums.Prize

class LotteryNumbers(
    val lotteryNumbers: List<LotteryNumber>
) {
    init {
        require(lotteryNumbers.size == LOTTERY_NUMBER_SIZE) { "로또의 추첨 번호는 ${LOTTERY_NUMBER_SIZE}개입니다." }
    }

    fun contains(lotteryNumber: LotteryNumber): Boolean = this.lotteryNumbers.contains(lotteryNumber)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LotteryNumbers

        if (lotteryNumbers != other.lotteryNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lotteryNumbers.hashCode()
    }

    override fun toString(): String {
        return "[${this.lotteryNumbers.map { it.toString() }.joinToString(separator = ",")}]"
    }

    fun findPrize(targetLotteryNumbers: LotteryNumbers): Prize {
        val countEqualLotteryNumbers = countEqualLotteryNumbers(targetLotteryNumbers)
        return Prize.find(countEqualLotteryNumbers.toLong())
    }

    private fun countEqualLotteryNumbers(targetLotteryNumbers: LotteryNumbers): Int {
        return this.lotteryNumbers.filter {
            targetLotteryNumbers.contains(it)
        }.size
    }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
    }
}
