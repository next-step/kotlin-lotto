package lotto

import kotlin.math.floor

object OutputView {
    private const val PRINT_VALID_MATCH_COUNT = 3
    private const val PERCENT_SCALE = 100

    fun printLotto(userLotto: List<LottoNumbers>) {
        println("${userLotto.size}개를 구매했습니다.")
        userLotto.forEach { println("[${ it }]") }.also { println() }
    }

    fun printResult(result: List<LottoResult>) {
        println("""
            |당첨 통계
            |---------
            |
            """.trimMargin() +
                result
                    .sortedBy { it.getWinningPrice() }
                    .filter { it.getMatchCount() >= PRINT_VALID_MATCH_COUNT }
                    .joinToString(separator = "\n") {
                        "${it.getMatchCount()}개 일치 (${it.getWinningPrice()}원) - ${it.count}개"
                    })
    }

    fun printProfitRate(computeProfitRate: Double) {
        println(String.format("총 수익률은 %.2f입니다.", floor(computeProfitRate * PERCENT_SCALE) / PERCENT_SCALE))
    }
}
