package next.step.racing.view

import next.step.lotto.domain.LottoRank
import next.step.lotto.domain.LottoWinningStat
import next.step.lotto.domain.Lottos

object OutputView {

    private const val UNKNOWN_ERR_MSG = "알 수 없는 에러가 발생했습니다."

    fun showLottos(manualLottos: Lottos, randomLottos: Lottos) {
        println()
        println("수동으로 ${manualLottos.size()}장, 자동으로 ${randomLottos.size()}장을 구매했습니다.")
        (manualLottos + randomLottos).numbers().forEach { println(it.sorted()) }
        println()
    }

    fun showWinningStats(winningStat: LottoWinningStat) {
        println()
        println("당첨 통계")
        println("---------")
        winningStat.filter { it.key != LottoRank.MISS }
            .forEach { println("${it.key.matchCount}개 일치${bonus(it.key.shouldMatchBonus())} (${it.key.winnings}원)- ${it.value}개") }
    }

    private fun bonus(matchBonus: Boolean): String = if (matchBonus) ", 보너스 볼 일치" else ""

    fun showPerformance(performance: String) {
        println("총 수익률은 ${performance}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n")
    }

    fun showError(msg: String?) {
        println(msg ?: UNKNOWN_ERR_MSG)
        println()
    }
}
