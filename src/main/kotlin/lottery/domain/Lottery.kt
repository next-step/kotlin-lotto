package lottery.domain

data class Lottery(val lotteryNumbers: LotteryNumbers) {
    override fun toString(): String {
        return "$lotteryNumbers"
    }

    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}
