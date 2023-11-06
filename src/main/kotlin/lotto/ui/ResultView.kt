package lotto.ui

class ResultView {
    fun show(statistics: Map<Int, Int>, winningPrize: Map<Int, Int>) {
        println("당첨 통계")
        for (i in 3..6) {
            val count = statistics.getOrDefault(i, 0)
            println("$i 개 일치 (${winningPrize.get(i)}원)- $count 개")
        }
    }
}
