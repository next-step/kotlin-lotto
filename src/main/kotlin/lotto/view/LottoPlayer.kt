package lotto.view

import lotto.model.Lotto
import lotto.service.LottoPlayResultAnalysis

object LottoPlayer {
    private fun formatWinningRatio(winningRatio: Double) = String.format("%.2f", winningRatio)

    fun printResult(winningLottos: List<Lotto>, winningRatio: Double) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${LottoPlayResultAnalysis.staticPrize(winningLottos, 5000)}")
        println("4개 일치 (50000원)- ${LottoPlayResultAnalysis.staticPrize(winningLottos, 50000)}")
        println("5개 일치 (1500000원)- ${LottoPlayResultAnalysis.staticPrize(winningLottos, 1500000)}")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${LottoPlayResultAnalysis.staticPrize(winningLottos, 30000000)}")
        println("6개 일치 (2000000000원)-${LottoPlayResultAnalysis.staticPrize(winningLottos, 2000000000)}")
        println()
        println("총 수익률은 ${formatWinningRatio(winningRatio)} 입니다.(기준이 1이기 때문에 결과적으로 ${if (winningRatio >= 1) "이득" else "손해"}라는 의미임)")
    }

}
