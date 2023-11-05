package lotto.view

import lotto.LottoList
import lotto.LottoRank
import lotto.LottoResultList
import lotto.Money

object ResultView {
    fun printLottoList(lottoList: LottoList) {
        println("${lottoList.size}개를 구매했습니다.")
        for (lotto in lottoList.lottoList) {
            println(lotto.lottoNumbers.numbers)
        }
    }

    fun printResult(result: LottoResultList, purchaseAmount: Money) {
        println("당첨 통계")
        println("------------")
        printRankResult(LottoRank.FOURTH, result.count(LottoRank.FOURTH))
        printRankResult(LottoRank.THIRD, result.count(LottoRank.THIRD))
        printRankResult(LottoRank.SECOND, result.count(LottoRank.SECOND))
        printRankResult(LottoRank.FIRST, result.count(LottoRank.FIRST))
        println("총 수익률은 ${result.getProfitRate(purchaseAmount.amount)}입니다.")
    }

    private fun printRankResult(rank: LottoRank, count: Int) {
        println("${rank.containCount}개 일치 (${rank.money}원)- ${count}개")
    }
}
