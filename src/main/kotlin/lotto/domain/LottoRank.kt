package lotto.domain

import lotto.common.IntegerNumber

enum class LottoRank(
    val hitCount: IntegerNumber,
    val prizeMoney: IntegerNumber,
    val hasBonusNumber: Boolean = false
) {
    FIRST(hitCount = IntegerNumber(6), prizeMoney = IntegerNumber(2000000000)),
    SECOND(hitCount = IntegerNumber(5), prizeMoney = IntegerNumber(30000000), hasBonusNumber = true),
    THIRD(hitCount = IntegerNumber(5), prizeMoney = IntegerNumber(1500000)),
    FOURTH(hitCount = IntegerNumber(4), prizeMoney = IntegerNumber(50000)),
    FIFTH(hitCount = IntegerNumber(3), prizeMoney = IntegerNumber(5000)),
    MISS(hitCount = IntegerNumber(0), prizeMoney = IntegerNumber(0));

    private fun isHitBonusNumber(it: LottoRank, hasBonusNumber: Boolean): Boolean {
        if (it.hasBonusNumber) {
            return hasBonusNumber
        }
        return true
    }

    companion object {
        fun from(hitCount: IntegerNumber, hasBonusNumber: Boolean): LottoRank {
            return values().find { it.hitCount == hitCount && it.isHitBonusNumber(it, hasBonusNumber) } ?: return MISS
        }

        fun winRanks(): List<LottoRank> {
            return values().filter { it.prizeMoney.isPositive() }.reversed()
        }
    }
}
