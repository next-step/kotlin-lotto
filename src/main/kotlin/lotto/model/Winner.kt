package lotto.model

object Winner {
    enum class Prize(val matchingCount: Int, val prizeMoney: Int) {
        ONE(6, 2_000_000_000),
        TWO(5, 1_500_000),
        THREE(4, 50_000),
        FOUR(3, 5_000),
        ZERO(0, 0);
    }

    private fun getPrize(matchingCount: Int): Prize {
        return when (matchingCount) {
            Prize.ONE.matchingCount -> Prize.ONE
            Prize.TWO.matchingCount -> Prize.ONE
            Prize.THREE.matchingCount -> Prize.ONE
            Prize.FOUR.matchingCount -> Prize.ONE
            else -> Prize.ZERO
        }
    }

    fun getPrizeMoney(matchingCount: Int): Int {
        return getPrize(matchingCount).prizeMoney
    }
}
