package autolotto.view

import autolotto.calculator.LottoCalculator
import autolotto.dto.LottoResultResponse
import autolotto.entity.Lotto

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
        lottoResultResponse: LottoResultResponse
    ) {
        println("당첨 통계")
        println("---------")
        printLottoResult(lottoResultResponse.getWinnerResults())
        println("총 수익률은 ${lottoResultResponse.getProfit()}입니다.${if (lottoResultResponse.getProfit() < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }

    private fun printLottoResult(lottos: List<String>) {
        lottos.forEach { lottoResult -> println(lottoResult) }
    }
}
