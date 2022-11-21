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
}
