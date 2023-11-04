package lotto.view

import lotto.LottoList
import lotto.LottoRank
import lotto.LottoResultList

object ResultView {
    fun printLottoList(lottoList: LottoList) {
        println("${lottoList.size}개를 구매했습니다.")
        for (lotto in lottoList.lottoList) {
            println(lotto.lottoNumbers.numbers)
        }
    }

    fun printResult(result: LottoResultList, purchaseAmount: Int) {
        println("당첨 통계")
        println("------------")
        printRankResult(LottoRank.FOURTH, result.fourthNum)
        printRankResult(LottoRank.THIRD, result.thirdNum)
        printRankResult(LottoRank.SECOND, result.secondNum)
        printRankResult(LottoRank.FIRST, result.firstNum)
        println("총 수익률은 ${result.getProfitRate(purchaseAmount)}입니다.")
    }

    private fun printRankResult(rank: LottoRank, count: Int) {
        println("${rank.containCount}개 일치 (${rank.money}원)- ${count}개")
    }
}
