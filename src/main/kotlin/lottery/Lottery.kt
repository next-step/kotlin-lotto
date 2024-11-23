package lottery

data class Lottery(val lotteryNumbers: LotteryNumbers) {
    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}
