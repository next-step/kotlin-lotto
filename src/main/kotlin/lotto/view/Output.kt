package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize

class Output {
    fun printLottoList(lottoList: List<Lotto>, manualCount: Int) {
        println("수동으로 ${manualCount}장, 자동으로 ${lottoList.size - manualCount}장을 구매했습니다.")
        lottoList.forEach { println(it) }
    }

    fun printResult(result: List<Prize>) {
        val lines = mutableListOf("당첨 통계", "---------")

        Prize.values().sortedBy { it.prize }.forEach { type ->
            if (type.prize <= 0) return@forEach

            val line = buildString {
                append("${type.match}개 일치")
                if (type == Prize.SECOND) append(", 보너스 볼 일치")
                append(" (${type.prize}원) - ${result.count { it == type }}개")
            }
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
