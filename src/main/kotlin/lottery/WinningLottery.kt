package lottery

class WinningLottery(val lotteryNumbers: LotteryNumbers) {
    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(LotteryNumbers(numbers))
        }
    }
}