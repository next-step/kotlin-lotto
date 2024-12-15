package lotto.view

import lotto.calculator.LottoCalculator
import lotto.entity.Lotto
import lotto.entity.LottoInfo
import lotto.enums.prize.Prize

object OutPutView {
    private const val BONUS_CONDITION_NAME = "BONUS"

    fun printLottoInfo(lotto: Lotto) {
        val manualInfo = lotto.manualLotto
        val autoInfo = lotto.autoLotto

        println("수동으로 ${manualInfo.size}장 자동으로  ${autoInfo.size}개를 구매했습니다.")
        manualInfo.forEach { printLotto(it) }
        autoInfo.forEach { printLotto(it) }
    }

    fun printLotto(lottoInfo: LottoInfo) {
        for (number in lottoInfo.getNumbers()) {
            print("$number ")
        }
        println()
    }

    fun printLottoResults(
        lottoResultResponse: Map<Prize, Int>,
        amount: Int,
    ) {
        println("당첨 통계")
        println("---------")
        printLottoResult(lottoResultResponse)
        val totalPrize = LottoCalculator.getTotalPrize(lottoResultResponse)
        val profit = LottoCalculator.getProfitRate(totalPrize, amount)
        println("총 수익률은 ${profit}입니다.${if (profit < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }

    private fun printLottoResult(lottoResultResponse: Map<Prize, Int>) {
        lottoResultResponse.forEach { (prize, count) ->
            println(
                "${prize.matchCount}개 일치${
                    if (prize.name.equals(
                            BONUS_CONDITION_NAME,
                        )
                    ) {
                        ", 보너스 볼 일치"
                    } else {
                        ""
                    }
                } (${prize.prizeMoney}원) - ${count}개",
            )
        }
    }
}
