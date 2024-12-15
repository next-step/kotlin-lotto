package lotto.view

import lotto.calculator.LottoCalculator
import lotto.entity.Lotto
import lotto.enums.prize.Prize

object OutPutView {
    private const val BONUS_CONDITION_NAME = "BONUS"

    fun printLottoInfo(lottos: List<Lotto>) {
        repeat(lottos.size) {
            printLotto(lottos[it])
        }
    }

    fun printLotto(lotto: Lotto) {
        for (number in lotto.getNumbers()) {
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
                "${prize.matchCount}개 일치${if (prize.name.equals(
                        BONUS_CONDITION_NAME,
                    )
                ) {
                    ", 보너스 볼 일치"
                } else {
                    ""
                }} (${prize.prizeMoney}원) - ${count}개",
            )
        }
    }
}
