package lotto.application.console

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.LottoResultSummary

object ResultView {

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { printLotto(it) }
        println()
    }

    fun printSummary(summary: LottoResultSummary) {
        println()
        println("당첨 통계")
        println("---------")
        summary.winResults().forEach { printLottoResult(it) }
        println("총 수익률은 ${summary.rateOfReturn()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.numbers.joinToString(", ", "[", "]"))
    }

    private fun printLottoResult(lottoResult: Pair<LottoResult, Int>) {
        val (result, count) = lottoResult
        println("${result.matchCount}개 일치 (${result.winningAmount}원)- ${count}개")
    }
}
