package lottery

class WinningLottery(val lotteryNumbers: LotteryNumbers) {
    fun countMatchedNumber(numbers: List<Int>): Int {
        return lotteryNumbers.countMatchedNumber(numbers)
    }

    companion object {
        fun create(numbers: Set<Int>): WinningLottery {
            return WinningLottery(LotteryNumbers(numbers))
        }
    }
}
