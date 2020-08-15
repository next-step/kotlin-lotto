package lotto.view

import lotto.model.LottoNo
import lotto.model.LottoPaper
import lotto.model.Win

object ResultView {
    fun printLottoCount(manualLottos: LottoPaper, autoLottos: LottoPaper) {
        println("수동으로 ${manualLottos.getLottoCount()}장, 자동으로 ${autoLottos.getLottoCount()}장을 구매했습니다.")
    }

    fun printLottos(paper: LottoPaper) {
        paper.lottoInPaper.forEach { it ->
            println("${it.lottoNumbers.map { LottoNo.to(it) }}")
        }
    }

    fun printMatchResult(paper: LottoPaper) {
        println("당첨 통계")
        println("---------")

        Win.values().filter { it.hasPrize() }.forEach { win ->
            var resultSentence = "${win.matchNumber}개 일치"

            if (win.matchBonus) {
                resultSentence += ", 보너스 볼 일치"
            }

            resultSentence += "(${win.prize.money}원)- ${paper.wins.filter { it == win }.size}개"

            println(resultSentence)
        }
    }

    fun printEarningRate(result: Double) {
        println("총 수익률은 ${result}입니다.")
    }
}
