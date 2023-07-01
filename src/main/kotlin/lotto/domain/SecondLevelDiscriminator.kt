package lotto.domain

class SecondLevelDiscriminator {

    companion object {
        fun checkPrizeLevelIsSecond(
            prizeLevel: PrizeLevel,
            lotteryPaper: LotteryPaper,
            bonusNumber: LottoNumber
        ): PrizeLevel {
            if (checkPrizeLevelIsThird(prizeLevel)) {
                return checkBonusNumberInLotteryPaper(lotteryPaper, bonusNumber)
            }
            return prizeLevel
        }

        private fun checkPrizeLevelIsThird(prizeLevel: PrizeLevel): Boolean {
            return prizeLevel == PrizeLevel.THIRD
        }

        private fun checkBonusNumberInLotteryPaper(lotteryPaper: LotteryPaper, bonusNumber: LottoNumber): PrizeLevel {
            if (lotteryPaper.getLottoNumbers().contains(bonusNumber)) {
                return PrizeLevel.SECOND
            }
            return PrizeLevel.THIRD
        }
    }
}
