package lotto.domain

enum class LottoRank(
    val hitCount: Int,
    val hasBonusNumber: Boolean,
    val prizeMoney: Int
) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    companion object {
        fun from(hitCount: Int, hasBonusNumber: Boolean): LottoRank {
            return values().find { it.hitCount == hitCount && isHitBonusNumber(it, hasBonusNumber) } ?: return MISS
        }

        private fun isHitBonusNumber(it: LottoRank, hasBonusNumber: Boolean): Boolean {
            if (it.hasBonusNumber) {
                return hasBonusNumber
            }
            return true
        }

        fun winRanks(): List<LottoRank> {
            return values().filter { it.prizeMoney > 0 }.reversed()
        }
    }
}
