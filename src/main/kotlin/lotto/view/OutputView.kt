package lotto.view

import lotto.LottoData
import lotto.WinnerLottoData

class OutputView {

    fun showPurchases(lottoDataList: List<LottoData>) {
        val purchaseCount = lottoDataList.size
        println("${purchaseCount}개를 구매했습니다.")
        lottoDataList.forEach { println(it.numbers) }
    }

    fun showResult(winnerLottoData: WinnerLottoData) {
        println("당첨 통계")
        println("---------")

        winnerLottoData.getLottoPrizeDataList().forEach {
            println("${it.matchCount}개 일치 (${it.prizeMoney}원)- ${winnerLottoData.getWinnerStepCount(it.matchCount)}개")
        }

        val prizeRate = winnerLottoData.getPrizeRate()
        val resultMessage = StringBuilder()
        resultMessage.apply {
            append("총 수익률은 ${prizeRate}입니다.")
            append(if (prizeRate < 1) "총 수익률은 ${prizeRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "")
        }

        println(resultMessage)
    }
}
