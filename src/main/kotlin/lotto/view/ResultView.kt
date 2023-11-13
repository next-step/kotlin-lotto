package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMatchResult

object ResultView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto ->
            println(lotto.map { it.value })
        }
        println()
    }

    fun printMatchResult(lottoMatchResult: LottoMatchResult) {
        println()
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${lottoMatchResult.three}개")
        println("4개 일치 (50000원)- ${lottoMatchResult.four}개")
        println("5개 일치 (1500000원)- ${lottoMatchResult.five}개")
        println("6개 일치 (2000000000원)- ${lottoMatchResult.six}개")
        println("총 수익률은 %.2f입니다.".format(lottoMatchResult.totalReturnRatio))
    }
}
