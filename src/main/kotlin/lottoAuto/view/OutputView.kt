package lottoAuto.view

import lottoAuto.domain.*

object OutputView {
    fun printNumOfLotto(numOfLotto: Int) {
        println("${numOfLotto}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printStatisticsHeader() {
        println("\n당첨 통계")
        println("---------")
    }

    fun printLottoStatistics(matchCount: Int, winningMoney: Int, countValue: Int) {
        println("${matchCount}개 일치 (${winningMoney}원) - ${countValue}개")
    }

    fun printBonusNumberStatistics(matchCount: Int, winningMoney: Int, countValue: Int) {
        println("${matchCount}개 일치, 보너스 볼 일치(${winningMoney}원) - ${countValue}개")
    }

    fun printProfitResult(rateOfReturn: Double, resultMsg: String) {
        println("총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${resultMsg}(이)라는 의미임)")
    }
}
