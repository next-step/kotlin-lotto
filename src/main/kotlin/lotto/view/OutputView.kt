package lotto.view

import lotto.dto.LottosDto

object OutputView {
    fun printResultMessage() {
        println("당첨 통계\n---------")
    }

    fun printLottos(lottosDto: LottosDto) {
        val lottos = lottosDto.lottos
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it) }
    }

    private fun printResult(entry: Map.Entry<String, Int>) {
        println(entry.key + " : " + "-".repeat(entry.value))
    }

    private fun printRatio(ratio: Double) {
        println("총 수익률은 ${String.format("%.2f", ratio)}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
