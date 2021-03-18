package lottery.domain

class Lottery(val lotteryNumbers: LotteryNumbers, val price: Int = DEFAULT_LOTTO_PRICE) {
    companion object {
        const val DEFAULT_LOTTO_PRICE = 1000
    }

    override fun toString(): String {
        return lotteryNumbers.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lottery

        if (lotteryNumbers != other.lotteryNumbers) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lotteryNumbers.hashCode()
        result = 31 * result + price
        return result
    }
}
