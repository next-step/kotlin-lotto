package lotto.domain.vo

class LotteryNumbers(
    private val lotteryNumbers: Set<LotteryNumber>
) {
    init {
        require(lotteryNumbers.size == LOTTERY_NUMBER_SIZE) { "로또의 추첨 번호는 ${LOTTERY_NUMBER_SIZE}개입니다." }
    }

    fun contains(lotteryNumber: LotteryNumber): Boolean = this.lotteryNumbers.contains(lotteryNumber)

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
    }
}