package lottoAuto.domain

enum class LottoRank(val matchCount: Int, val winningMoney: Int) {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun from(matchCount: Int, withBonus: Boolean = false): LottoRank {
            if (BONUS.matchCount == matchCount && withBonus) {
                return BONUS
            }
            return values().find {
                it.matchCount == matchCount
            } ?: MISS
        }
    }
}
