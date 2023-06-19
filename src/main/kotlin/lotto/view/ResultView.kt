package lotto.view

object ResultView {
    fun printPurchaseResult(count: Int){
        println("${count}개를 구매했습니다.")
    }

    fun printWinningStatistics(){
        println("당첨 통계")
        println("---------")
    }

    fun printRateOfReturn(rate: Float){
        println("총 수익률은 ${rate}입니다.")
    }
}
