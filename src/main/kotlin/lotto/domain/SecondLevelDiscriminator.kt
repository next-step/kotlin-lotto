package lotto.domain

class SecondLevelDiscriminator {

    companion object {
        fun checkPrizeLevelIsSecond(
            prizeLevel: PrizeLevel,
            lotteryPaper: LotteryPaper,
            bonusBall: BonusBall
        ): PrizeLevel {
            if (checkPrizeLevelIsThird(prizeLevel)) {
                return checkBonusNumberInLotteryPaper(lotteryPaper, bonusBall)
            }
            return prizeLevel
        }

        private fun checkPrizeLevelIsThird(prizeLevel: PrizeLevel): Boolean {
            return prizeLevel == PrizeLevel.THIRD
        }

        private fun checkBonusNumberInLotteryPaper(lotteryPaper: LotteryPaper, bonusBall: BonusBall): PrizeLevel {
            if (lotteryPaper.getLottoNumber().contains(bonusBall.bonusNumber)) {
                return PrizeLevel.SECOND
            }
            return PrizeLevel.THIRD
        }
    }
}
