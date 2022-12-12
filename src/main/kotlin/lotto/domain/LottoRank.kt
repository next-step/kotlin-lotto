package lotto.domain

import lotto.common.Number

enum class LottoRank(
    val hitCount: Number,
    val prizeMoney: Number,
    val hasBonusNumber: Boolean = false
) {
    FIRST(hitCount = Number(6), prizeMoney = Number(2000000000)),
    SECOND(hitCount = Number(5), prizeMoney = Number(30000000), hasBonusNumber = true),
    THIRD(hitCount = Number(5), prizeMoney = Number(1500000)),
    FOURTH(hitCount = Number(4), prizeMoney = Number(50000)),
    FIFTH(hitCount = Number(3), prizeMoney = Number(5000)),
    MISS(hitCount = Number(0), prizeMoney = Number(0));

    private fun isHitBonusNumber(it: LottoRank, hasBonusNumber: Boolean): Boolean {
        if (it.hasBonusNumber) {
            return hasBonusNumber
        }
        return true
    }

    companion object {
        fun from(hitCount: Number, hasBonusNumber: Boolean): LottoRank {
            return values().find { it.hitCount == hitCount && it.isHitBonusNumber(it, hasBonusNumber) } ?: return MISS
        }

        fun winRanks(): List<LottoRank> {
            return values().filter { it.prizeMoney.isPositive() }.reversed()
        }
    }
}
