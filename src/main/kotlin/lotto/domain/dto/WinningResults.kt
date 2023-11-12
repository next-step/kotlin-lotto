package lotto.domain.dto

data class WinningResults(val winningResults: List<WinningResult>) {
    fun printResult() {
        println("당첨 통계")
        winningResults.forEach {
            it.printResult()
        }
    }

    fun printRateOfReturn(money : Int) {
        var totalPrize = 0
        winningResults.forEach {
            if (it.count != 0) totalPrize += it.prize
        }
        println("총 수익률은 ${totalPrize.toFloat() / money}")
    }
}
