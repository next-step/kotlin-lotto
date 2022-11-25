package lotto.uI

import lotto.domain.Lotto
import lotto.domain.LottoMatch

object OutputView {
    fun outputLottoList(lottoList: List<Lotto>) {
        println("${lottoList.count()}${MessageCode.PURCHASE_COUNT_RESULT.message}")
        lottoList.forEach { lotto ->
            println(lotto.numbers)
        }
    }

    fun outputLottoStatistics(lottMatchList: List<LottoMatch>) {
        println(MessageCode.RESULT_STATISTICS.message)
        lottMatchList.forEach { lottoMatch ->
            println("${lottoMatch.matchNumber}개 일치 (${lottoMatch.reward}원)- ${lottoMatch.matchCount}개")
        }
    }

    fun outputLottoProfit(profit: Double, isShow: Boolean) {
        print("총 수익률은 ${profit}입니다.")
        if (isShow)println(MessageCode.RESULT_STANDARD_PROFIT_RATIO.message)
    }
}
