package lotto.domain

enum class PrizeLevel(val numberOfHit: Int, val prizeMoney: Int, hasBonus: Boolean = false) {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {

        fun fromNumberOfHit(numberOfHit: Int, lotteryPaper: LotteryPaper, bonusNumber: LottoNumber): PrizeLevel {
            val prizeLevel = values().firstOrNull { it.numberOfHit == numberOfHit } ?: NONE
            if (prizeLevel == THIRD && lotteryPaper.hasBonusNumber(bonusNumber)) {
                return SECOND
            }
            return prizeLevel
        }
    }
}
