package lottery.domain

data class WinningLottery(val lotteryNumbers: LotteryNumbers) {
    fun countMatchedNumber(other: Lottery): Int {
        return lotteryNumbers.countMatchedNumber(other.lotteryNumbers)
    }

    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(LotteryNumbers(numbers.toSet()))
        }
    }
}
