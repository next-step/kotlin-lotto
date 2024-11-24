package lotto

import kotlin.math.floor

object OutputView {
    private const val PRINT_VALID_MATCH_COUNT = 3
    private const val PERCENT_SCALE = 100

    fun printLotto(userLotto: List<LottoNumbers>) {
        println("${userLotto.size}개를 구매했습니다.")
        userLotto.forEach { println("[${it}]") }.also { println() }
    }

    fun printResult(result: List<LottoResult>) {
        StringBuilder().apply {
            append("\n당첨 통계\n")
            append("---------\n")
            result
                .sortedBy { it.getWinningPrice() }
                .forEach {
                    if (it.getMatchCount() >= PRINT_VALID_MATCH_COUNT) {
                        append("${it.getMatchCount()}개 일치 ")
                        append("(${it.getWinningPrice()}원) - ${it.count}개\n")
                    }
                }
        }.also(::println)
    }

    fun printProfitRate(computeProfitRate: Double) {
        println(String.format("총 수익률은 %.2f입니다.", floor(computeProfitRate * PERCENT_SCALE) / PERCENT_SCALE))
    }
}