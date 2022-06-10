package lotto.ui

class ResultView {
    fun showMatchResult(result: List<Int>) {
        println("\n당첨 통계")
        println("---------")
        result.onEach { it ->
            println(it)
            // println("${winningInfo.winningCount}개 일치 (${winningInfo.winningMoney}원) - ${count}개")
        }
        // println("총 수익률은 입니다.")
    }
}
