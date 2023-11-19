package lottoAuto.view

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

    fun printStatistics(matchCount: Int,
                        winningMoney: Int,
                        countValue: Int,
                        isBonusMatch: Boolean) {
        if (isBonusMatch) {
            println("${matchCount}개 일치, 보너스 볼 일치(${winningMoney}원) - ${countValue}개")
        } else {
            println("${matchCount}개 일치 (${winningMoney}원) - ${countValue}개")
        }
    }

    fun printProfitResult(rateOfReturn: Double, resultMsg: String) {
        println("총 수익률은 $rateOfReturn 입니다.(기준이 1이기 때문에 결과적으로 $resultMsg (이)라는 의미임)")
    }
}
