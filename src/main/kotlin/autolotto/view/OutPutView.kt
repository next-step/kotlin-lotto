package autolotto.view

import autolotto.calculator.LottoCalculator
import autolotto.entity.Lotto
import autolotto.enums.prize.Prize

object OutPutView {
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
            println("${prize.matchCount}개 일치 (${prize.prizeMoney}원) - ${count}개")
        }
    }
}
