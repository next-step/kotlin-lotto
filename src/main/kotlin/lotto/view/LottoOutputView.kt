package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRule
import lotto.domain.LottoStatistics

object LottoOutputView {
    /**
     * 구입한 로또의 결과를 출력한다.
     */
    fun printPurchaseLottoResult(lottos: List<Lotto>) {
        printPurchaseLottoCount(lottos)
        printLottos(lottos)
        println()
    }

    /**
     * 구입한 로또의 수를 출력한다.
     */
    fun printPurchaseLottoCount(lottos: List<Lotto>) = println("${lottos.size}개를 구매했습니다.")

    /**
     * 로또들의 번호들을 출력한다.
     */
    fun printLottos(lottos: List<Lotto>) =
        lottos.map { lotto -> println("${lotto.numbers.toList()}") }

    /**
     * 로또 당첨 통계를 출력한다.
     */
    fun printWinningStatistics(lottoStatistics: LottoStatistics) {
        println("당첨 통계")
        println("---------")
        println(LottoRule.LAST_PLACE.printRule(lottoStatistics.lastPlace))
        println(LottoRule.THIRD_PLACE.printRule(lottoStatistics.thirdPlace))
        println(LottoRule.SECOND_PLACE.printRule(lottoStatistics.secondPlace))
        println(LottoRule.FIRST_PLACE.printRule(lottoStatistics.firstPlace))
        print("총 수익률은 ${lottoStatistics.rateOfReward}입니다.")
        println("(기준이 1이기 때문에 결과적으로 ${getStringRateOfReward(lottoStatistics.rateOfReward)}라는 의미임)")
    }

    private fun getStringRateOfReward(rateOfReward: Double) = if (rateOfReward >= 1) "이익" else "손해"
}
