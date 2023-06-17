package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int) {
    FIRST(3, 5000),
    SECOND(4, 50000),
    THIRD(5, 1500000),
    FOURTH(6, 2000000000),
    MISS(0, 0);

    companion object {
        fun from(matchCount: Int): LottoRank = values().find { it.matchCount == matchCount } ?: MISS
    }

}