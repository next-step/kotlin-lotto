package lottery

class Lottery(val lotteryNumbers: LotteryNumbers) {
    fun countMatchedNumber(other: Lottery): Int {
        return this.lotteryNumbers.countMatchedNumber(other.lotteryNumbers)
    }

    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}
