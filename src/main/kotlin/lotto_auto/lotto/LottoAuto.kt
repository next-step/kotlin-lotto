package lotto_auto.lotto

object LottoAuto {
    fun matchedLottoCountWithBonusBall(
        lottoList: List<Lotto>,
        lastWeekLottoNumber: WinningLotto,
    ): List<Pair<LottoPrize, Boolean>> {
        return lottoList
            .map { it.lottoMatchCount(lastWeekLottoNumber) to it.isMatchedBonusBall(lastWeekLottoNumber.bonusNumber) }
    }

    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(eachLottoMatchList: List<Pair<LottoPrize, Boolean>>): Int {
        return eachLottoMatchList.sumOf {
            lottoPrizeWithMatchCountAndBonusMatched(it.first.matchCount, it.second).winningAmount
        }
    }

    /**
     * match 개수 만큼 LottoPrize로 변경
     */
    private fun lottoPrizeWithMatchCountAndBonusMatched(matchCount: Int, bonusMatched: Boolean): LottoPrize {
        return LottoPrize.getLottoPrize(matchCount, bonusMatched)
    }

    fun matchCountList(eachLottoMatchList: List<LottoPrize>): Map<LottoPrize, Int> {
        return eachLottoMatchList.groupingBy { it }.eachCount()
    }

    fun earningRate(sumOfWonLotto: Int, inputAmount: Int): Float {
        return sumOfWonLotto.toFloat() / inputAmount.toFloat()
    }
}
