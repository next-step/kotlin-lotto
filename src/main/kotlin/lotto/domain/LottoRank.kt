package lotto.domain

enum class LottoRank(
    val hitCount: Int,
    val prizeMoney: Int,
    val hasBonusNumber: Boolean = false
) {
    FIRST(hitCount = 6, prizeMoney = 2000000000),
    SECOND(hitCount = 5, prizeMoney = 30000000, hasBonusNumber = true),
    THIRD(hitCount = 5, prizeMoney = 1500000),
    FOURTH(hitCount = 4, prizeMoney = 50000),
    FIFTH(hitCount = 3, prizeMoney = 5000),
    MISS(hitCount = 0, prizeMoney = 0);

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
