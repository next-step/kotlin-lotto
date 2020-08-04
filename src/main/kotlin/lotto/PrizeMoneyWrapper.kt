package lotto

class PrizeMoneyWrapper(prizeMoney: PrizeMoney, prizeCount: Int) {
    var prizeMoney: PrizeMoney = prizeMoney
        private set
    var prizeCount: Int = prizeCount
        private set

    fun calculatePrizeMoney(): Int {
        return prizeMoney.getPrizeMoney() * prizeCount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PrizeMoneyWrapper

        if (prizeMoney != other.prizeMoney) return false
        if (prizeCount != other.prizeCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = prizeMoney.hashCode()
        result = 31 * result + prizeCount
        return result
    }
}
