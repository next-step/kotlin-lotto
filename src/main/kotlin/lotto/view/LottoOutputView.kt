package lotto.view

import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.Rank

object LottoOutputView {
    /**
     * 구입한 로또의 결과를 출력한다.
     */
    fun printPurchaseLottoResult(lottos: Lottos, manualLottos: Lottos) {
        printPurchaseLottoCount(lottos, manualLottos)
        printLottos(lottos)
        println()
    }

    /**
     * 구입한 로또의 수를 출력한다.
     */
    fun printPurchaseLottoCount(lottos: Lottos, manualLottos: Lottos) {
        println("수동으로 ${manualLottos.count}장, 자등으로 ${lottos.count - manualLottos.count}장을 구매했습니다.")
    }

    /**
     * 로또들의 번호들을 출력한다.
     */
    fun printLottos(lottos: Lottos) =
        lottos.lottoList.map { lotto -> println("${lotto.numbers.map { it.number }}") }

    /**
     * 로또 당첨 통계를 출력한다.
     */
    fun printWinningStatistics(lottoStatistics: LottoStatistics) {
        println("당첨 통계")
        println("---------")
        lottoStatistics.matchResult.toSortedMap(compareByDescending { it.ordinal }).map { result ->
            printLottoRuleResult(result.key, result.value)
        }
        val rateOfReward = lottoStatistics.getRateOfReward()
        print("총 수익률은 ${rateOfReward}입니다.")
        println("(기준이 1이기 때문에 결과적으로 ${getStringRateOfReward(rateOfReward)}라는 의미임)")
    }

    /**
     * 로또 당첨 규칙에 따른 결과를 출력한다.
     */
    fun printLottoRuleResult(rank: Rank, count: Int) {
        when (rank) {
            Rank.SECOND -> println("${rank.countOfMatch}개 일치, 보너스 볼 일치 (${rank.winningMoney}원) - ${count}개")
            Rank.MISS -> return
            else -> println("${rank.countOfMatch}개 일치 (${rank.winningMoney}원) - ${count}개")
        }
    }

    private fun getStringRateOfReward(rateOfReward: Double) = if (rateOfReward >= 1) "이익" else "손해"
}
