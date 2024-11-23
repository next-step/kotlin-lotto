package lottery

class Lottery(val lotteryNumbers: LotteryNumbers) {
    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}
