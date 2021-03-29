package lottery.domain

class Lottery(val lotteryNumbers: LotteryNumbers) {
    fun hasBonusBall(bonusBall: BonusBall): Boolean {
        return lotteryNumbers.contains(bonusBall.number)
    }

    override fun toString(): String {
        return lotteryNumbers.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lottery

        if (lotteryNumbers != other.lotteryNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        return lotteryNumbers.hashCode()
    }
}
