package lottery.domain

data class WinningLottery(val lottery: Lottery) {
    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(Lottery(LotteryNumbers(numbers.toSet())))
        }
    }
}
