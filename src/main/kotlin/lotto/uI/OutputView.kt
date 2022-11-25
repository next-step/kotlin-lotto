package lotto.uI

import lotto.domain.Lotto
import lotto.domain.LottoMatch
import lotto.domain.LottoRank

object OutputView {
    private const val BLANK = " "

    fun outputLottoList(lottoList: List<Lotto>) {
        println("${lottoList.count()}${MessageCode.PURCHASE_COUNT_RESULT.message}")
        lottoList.forEach { lotto ->
            println(lotto.numbers)
        }
    }

    fun outputLottoStatistics(lottMatchList: List<LottoMatch>) {
        println(MessageCode.RESULT_STATISTICS.message)
        lottMatchList.forEach { lottoMatch ->
            println("${lottoMatch.lottoRank.matchCount}개 일치${outputBonus(lottoMatch.lottoRank)}(${lottoMatch.lottoRank.reward}원)- ${lottoMatch.matchTotalCount}개")
        }
    }

    fun outputLottoProfit(profit: Double, isShow: Boolean) {
        print("총 수익률은 ${profit}입니다.")
        if (isShow) println(MessageCode.RESULT_STANDARD_PROFIT_RATIO.message)
    }

    private fun outputBonus(lottoRank: LottoRank): String =
        if (lottoRank.isBonus) MessageCode.BONUS_BALL_MATCH.message
        else BLANK
}
