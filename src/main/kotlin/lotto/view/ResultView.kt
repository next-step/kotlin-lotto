package lotto.view

import lotto.model.game.Lottos
import lotto.model.result.Result
import java.math.BigDecimal

object ResultView {
    fun printMyLottos(lottos: Lottos) {
        lottos.lottos.forEach { println(it.toString()) }
        println()
    }

    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
        println()
    }

    fun printResult(results: List<Result>) {
        printStatisticsInstruction()
        printResultStatistics(results)
    }

    fun printEarningRate(earningRate: BigDecimal) {
        println("총 수익률은 $earningRate")
    }

    private fun printResultStatistics(results: List<Result>) {
        results.forEach {
            val coincidence = it.coincidence
            val matchCount = it.matchCount

            print("${coincidence.coincidenceCount}개 일치")
            if (coincidence.hasBonusNum) print(" 보너스 볼 일치")
            print("(${coincidence.prizeMoney}원)")
            println("- ${matchCount}개")
        }
        println()
    }

    private fun printStatisticsInstruction() {
        println("당첨 통계")
        println("==============")
    }
}
