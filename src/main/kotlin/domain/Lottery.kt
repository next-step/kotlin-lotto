package domain

class Lottery(val numbers: LotteryNumbers, val price: Int = DEFAULT_LOTTO_PRICE) {
    companion object {
        const val DEFAULT_LOTTO_PRICE = 1000
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
