package lotto.view

import lotto.LottoData
import lotto.LottoPrizeData
import lotto.WinnerLottoData

object OutputView {

    fun showPurchases(lottoDataList: List<LottoData>) {
        val purchaseCount = lottoDataList.size
        println("${purchaseCount}개를 구매했습니다.")
        lottoDataList.forEach { println(it.numbers) }
    }

    fun showResult(winnerLottoData: WinnerLottoData) {
        println("당첨 통계")
        println("---------")

        winnerLottoData.getLottoPrizeDataList().forEach {
            if (it.includeBonusNumber) showPrintForBonus(it, winnerLottoData) else showPrint(it, winnerLottoData)
        }

        val prizeRate = winnerLottoData.getPrizeRate()
        val resultMessage = StringBuilder()
        resultMessage.apply {
            append("총 수익률은 ${prizeRate}입니다.")
            append(if (prizeRate < 1) "총 수익률은 ${prizeRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "")
        }

        println(resultMessage)
    }

    private fun showPrint(lottoPrizeData: LottoPrizeData, winnerLottoData: WinnerLottoData) {
        println(
            "${lottoPrizeData.matchCount}개 일치 " +
                "(${lottoPrizeData.prizeMoney}원)- " +
                "${winnerLottoData.getWinnerStepCount(lottoPrizeData.matchCount)}개"
        )
    }

    private fun showPrintForBonus(lottoPrizeData: LottoPrizeData, winnerLottoData: WinnerLottoData) {
        println(
            "${lottoPrizeData.matchCount}개 일치, " +
                "보너스 볼 일치(${lottoPrizeData.prizeMoney}원)- " +
                "${winnerLottoData.getWinnerStepCountWithBonusNumber(lottoPrizeData.matchCount)}개"
        )
    }
}
