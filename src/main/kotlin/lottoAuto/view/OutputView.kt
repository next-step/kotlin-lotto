package lottoAuto.view

import lottoAuto.domain.LottoRank
import lottoAuto.domain.LottoRankCounter

object OutputView {
    fun printNumOfLotto(numOfManualLotto: Int, numOfRandomLotto: Int) {
        println("\n수동으로 ${numOfManualLotto}장, 자동으로 ${numOfRandomLotto}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printStatisticsHeader() {
        println("\n당첨 통계")
        println("---------")
    }

    fun printStatistics(lottoRankCounter: LottoRankCounter) {
        lottoRankCounter
            .counter
            .entries
            .forEach {
                this.printStatisticsWithBonus(
                    it.key,
                    it.value,
                    it.key == LottoRank.BONUS
                )
            }
    }

    private fun printStatisticsWithBonus(
        lottoRank: LottoRank,
        countValue: Int,
        withBonus: Boolean
    ) {
        if (withBonus) {
            println("${lottoRank.matchCount}개 일치, 보너스 볼 일치(${lottoRank.winningMoney}원) - ${countValue}개")
            return
        }
        println("${lottoRank.matchCount}개 일치 (${lottoRank.winningMoney}원) - ${countValue}개")
    }

    fun printProfitResult(rateOfReturn: Double, resultMsg: String) {
        println("총 수익률은 $rateOfReturn 입니다.(기준이 1이기 때문에 결과적으로 $resultMsg (이)라는 의미임)")
    }
}
