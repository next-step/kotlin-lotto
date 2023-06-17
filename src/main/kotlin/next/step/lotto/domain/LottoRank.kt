package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int) {
    
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    companion object {
        fun from(matchCount: Int): LottoRank = values().find { it.matchCount == matchCount } ?: MISS
    }

}