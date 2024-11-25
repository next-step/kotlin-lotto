package lottery.domain

class Lottery(val lotteryNumbers: LotteryNumbers) {
    fun countMatchedNumber(other: Lottery): Int {
        return this.lotteryNumbers.countMatchedNumber(other.lotteryNumbers)
    }

    override fun toString(): String {
        return "$lotteryNumbers"
    }

    companion object {
        fun create(): Lottery {
            return Lottery(LotteryNumbers.create())
        }
    }
}
