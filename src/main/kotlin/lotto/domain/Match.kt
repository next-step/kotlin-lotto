package lotto.domain

enum class Match(val prize: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    BONUS(30000000),
    SIX(2000000000),
    NONE(0);

    companion object {
        fun valueOf(count: Int, isBonus: Boolean): Match {
            return mapper.getOrDefault(Pair(count, isBonus), NONE)
        }

        private val mapper = mapOf(
            Pair(3, true) to THREE,
            Pair(3, false) to THREE,
            Pair(4, true) to FOUR,
            Pair(4, false) to FOUR,
            Pair(5, true) to BONUS,
            Pair(5, false) to FIVE,
            Pair(6, true) to SIX,
            Pair(6, false) to SIX,
        )
    }
}
