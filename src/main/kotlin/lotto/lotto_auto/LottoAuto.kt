package lotto.lotto_auto

import lotto.lotto.Lotto
import lotto.lotto.LottoPrize
import lotto.result.LottoResult
import lotto.lotto.WinningLotto

object LottoAuto {
    fun matchedLottoCountWithBonusBall(
        lottoList: List<Lotto>,
        lastWeekLottoNumber: WinningLotto,
    ): List<LottoResult> {
        return lottoList
            .map {
                LottoResult(
                    it.lottoPrize(lastWeekLottoNumber),
                    it.isMatchedBonusBall(lastWeekLottoNumber.bonusNumber)
                )
            }
    }

    /**
     * 구매한 로또 총 당첨 금액
     */
    fun sumOfWonLottoList(eachLottoMatchList: List<LottoResult>): Int {
        return eachLottoMatchList.sumOf {
            lottoPrizeWithMatchCountAndBonusMatched(it.lottoPrize.matchCount, it.bonusBallMatched).winningAmount
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
