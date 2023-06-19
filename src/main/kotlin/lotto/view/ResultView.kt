package lotto.view

object ResultView {
    fun printPurchaseResult(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.count()}개를 구매했습니다.")
        lottoNumbers.forEach { lotto ->
            println(lotto)
        }
    }

    fun printWinningResultComment() {
        println("당첨 통계")
        println("---------")
    }

    fun printWinningResultStatistics(numberOfMatch: Int, reward: Int, count: Int) {
        println("${numberOfMatch}개 일치 (${reward}원)- ${count}개")
    }

    fun printRateOfReturn(rate: Float) {
        println("총 수익률은 ${rate}입니다.")
    }
}
