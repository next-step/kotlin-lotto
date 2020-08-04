package lotto.model

class Prize(
    matchingCount: Int
) {
    private val prize = getPrize(matchingCount)

    enum class PrizeMoney(val matchingCount: Int, val prizeMoney: Int) {
        ONE(6, 2_000_000_000),
        TWO(5, 1_500_000),
        THREE(4, 50_000),
        FOUR(3, 5_000),
        ZERO(0, 0);
    }

    private fun getPrize(matchingCount: Int): PrizeMoney {
        return when (matchingCount) {
            PrizeMoney.ONE.matchingCount -> PrizeMoney.ONE
            PrizeMoney.TWO.matchingCount -> PrizeMoney.TWO
            PrizeMoney.THREE.matchingCount -> PrizeMoney.THREE
            PrizeMoney.FOUR.matchingCount -> PrizeMoney.FOUR
            else -> PrizeMoney.ZERO
        }
    }

    fun getPrizeMoney(): Int {
        return prize.prizeMoney
    }

    fun isType(type: PrizeMoney) = prize == type

    override fun toString(): String {
        return "${prize.matchingCount} // ${prize.prizeMoney}"
    }

    companion object {
        fun newInstance(matchingCount: Int) = Prize(matchingCount)
    }
}

