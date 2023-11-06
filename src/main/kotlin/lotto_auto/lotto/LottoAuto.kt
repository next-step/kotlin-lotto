package lotto_auto.lotto

object LottoAuto {
    fun matchedLottoCountWithBonusBall(
        lottoList: List<Lotto>,
        lastWeekLottoNumber: Lotto,
        bonusBallNumber: Int
    ): List<Pair<Int, Boolean>> {
        return lottoList
            .map { it.lottoMatchCount(lastWeekLottoNumber) to it.isMatchedBonusBall(bonusBallNumber) }
    }

    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(eachLottoMatchList: List<Pair<Int, Boolean>>): Int {
        return eachLottoMatchList.sumOf {
            replaceMatchCountToMoney(it.first, it.second).winningAmount
        }
    }

    /**
     * match 개수 만큼 금액 으로 변경
     */
    private fun replaceMatchCountToMoney(matchCount: Int, bonusMatched: Boolean): LottoPrize {
        return LottoPrize.getLottoPrize(matchCount, bonusMatched)
    }

    fun matchCountList(eachLottoMatchList: List<LottoPrize>): Map<LottoPrize, Int> {
        return mapOf(
            LottoPrize.FIFTH_PRIZE to eachLottoMatchList.count { it == LottoPrize.FIFTH_PRIZE },
            LottoPrize.FOURTH_PRIZE to eachLottoMatchList.count { it == LottoPrize.FOURTH_PRIZE },
            LottoPrize.THIRD_PRIZE to eachLottoMatchList.count { it == LottoPrize.THIRD_PRIZE },
            LottoPrize.SECOND_PRIZE to eachLottoMatchList.count { it == LottoPrize.SECOND_PRIZE },
            LottoPrize.FIRST_PRIZE to eachLottoMatchList.count { it == LottoPrize.FIRST_PRIZE },
        )
    }

    fun earningRate(sumOfWonLotto: Int, inputAmount: Int): Float {
        return sumOfWonLotto.toFloat() / inputAmount.toFloat()
    }
}
