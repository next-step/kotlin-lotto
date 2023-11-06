package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize

class Output {
    fun printPurchasedAmount(purchased: Int) {
        println("$purchased 개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<Lotto>) {
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
        println("총 수익률은 $earningRate 입니다.(기준이 1이기 때문에 결과적으로 ${getResultWord(earningRate)}라는 의미임)")
    }

    private fun getResultWord(earningRate: Double): String {
        return when {
            earningRate == 1.0 -> "본전이"
            earningRate > 1.0 -> "이득이"
            else -> "손해"
        }
    }
}
