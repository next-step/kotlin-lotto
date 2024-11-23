package lottery

class WinningLottery(val lotteryNumbers: LotteryNumbers) {
    fun countMatchedNumber(numbers: List<Int>): Int {
        return lotteryNumbers.numbers.intersect(numbers.toSet()).size
    }

    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(LotteryNumbers(numbers))
        }
    }
}