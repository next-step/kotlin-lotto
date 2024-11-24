package lottery.domain

class WinningLottery(val lottery: Lottery) {
    fun draw(lotteries: List<Lottery>): DrawResult {
        return DrawResult.from(winningLottery = this, lotteries = lotteries)
    }

    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(Lottery(LotteryNumbers(numbers.toSet())))
        }
    }
}
