package lotto.domain

enum class LottoRank(
    val hitCount: Int,
    val prizeMoney: Money,
    val hasBonusNumber: Boolean = false
) {
    FIRST(hitCount = 6, prizeMoney = Money(2000000000)),
    SECOND(hitCount = 5, prizeMoney = Money(30000000), hasBonusNumber = true),
    THIRD(hitCount = 5, prizeMoney = Money(1500000)),
    FOURTH(hitCount = 4, prizeMoney = Money(50000)),
    FIFTH(hitCount = 3, prizeMoney = Money(5000)),
    MISS(hitCount = 0, prizeMoney = Money(0));

    private fun isHitBonusNumber(it: LottoRank, hasBonusNumber: Boolean): Boolean {
        if (it.hasBonusNumber) {
            return hasBonusNumber
        }
        return true
    }

    companion object {
        fun from(hitCount: Int, hasBonusNumber: Boolean): LottoRank {
            return values().find { it.hitCount == hitCount && it.isHitBonusNumber(it, hasBonusNumber) } ?: return MISS
        }

        fun winRanks(): List<LottoRank> {
            return values().filter { it.prizeMoney.amount > 0 }.reversed()
        }
    }
}
