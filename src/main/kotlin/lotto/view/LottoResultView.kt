package lotto.view

import lotto.LottoTicket
import lotto.LottoWinnerRank
import lotto.MyLottoResult

object LottoResultView {

    fun printPurchasedLottoInfo(lottos: List<LottoTicket>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            println(lotto.numbers)
        }
    }

    fun printLottoResult(myResult: MyLottoResult) {
        println("당첨통계")
        println("----------")

        LottoWinnerRank.getRankingList()
            .forEach { ranking ->
                printLottoRankingCountAndPrice(ranking, myResult.getCount(ranking))
            }
    }

    fun printLottoProfilt(profit: Double) {
        println("총 수익률은 ${profit}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printLottoRankingCountAndPrice(lottoRank: LottoWinnerRank, count: Int?) {
        println("${lottoRank.matchCount}개 일치 (${lottoRank.price}원) - ${count}개")
    }
}
