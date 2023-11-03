package lotto.ui

import lotto.util.Prize

class OutputView {
    fun printPurchasedAmount(purchased: Int) {
        println("$purchased 개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<List<Int>>) {
        lottoList.forEach { println(it) }
    }

    fun printResult(result: List<Prize>) {
        val lines = mutableListOf("당첨 통계", "---------")

        (3..6).forEach {
            val line = "${it}개 일치 (${Prize.getPrize(it).prize}원)- ${Prize.countResult(result, it)}개"
            lines.add(line)
        }

        println(lines.joinToString("\n"))
    }

    fun printEarningRate(result: List<Prize>, purchased: Int) {
        val earningRate = result.sumOf { it.prize } / purchased.toDouble()
        println("총 수익률은 $earningRate 입니다.")
    }
}
