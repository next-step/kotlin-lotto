package lotto.uI

import lotto.domain.LottoList
import lotto.domain.LottoMatch
import lotto.domain.LottoRank

object OutputView {
    private const val BLANK = " "

    fun outputLottoList(manualLottoCount: Long, autoLottoCount: Long, lottoList: LottoList) {
        println("수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}개를 구매했습니다.")
        lottoList.printLottoList()
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
        if (lottoRank == LottoRank.SECOND_PLACE) MessageCode.BONUS_BALL_MATCH.message
        else BLANK
}
