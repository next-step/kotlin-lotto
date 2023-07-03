package lotto.domain

class PrizeLevelDiscriminator {
    fun checkIsThirdLevel(prizeLevel: PrizeLevel, comparatorPair: Pair<LotteryPaper, LottoNumber>): PrizeLevel {
        if (prizeLevel == PrizeLevel.THIRD) {
            val (lotteryPaper, bonusNumber) = comparatorPair
            return matchBonusBall(lotteryPaper, bonusNumber)
        }
        return prizeLevel
    }

    private fun matchBonusBall(lotteryPaper: LotteryPaper, bonusNumber: LottoNumber): PrizeLevel {
        if (lotteryPaper.hasBonusNumber(bonusNumber)) {
            return PrizeLevel.SECOND
        }
        return PrizeLevel.THIRD
    }
}
