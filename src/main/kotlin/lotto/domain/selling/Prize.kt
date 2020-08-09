package lotto.domain.selling

enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    companion object {
        private val prizes = HashMap(values().associateBy { it.matchCount })

        operator fun invoke(matchCount: Int) = (prizes[matchCount] ?: NONE)
    }
}
