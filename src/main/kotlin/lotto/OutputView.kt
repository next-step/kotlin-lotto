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
        println(getHeader())
        println(getBody(result))
    }

    private fun getHeader() = """
                |당첨 통계
                |---------
                """.trimMargin()

    private fun getBody(result: List<LottoResult>): Any {
        return result
            .sortedBy { it.getWinningPrice() }
            .filter { it.getMatchCount() >= PRINT_VALID_MATCH_COUNT }
            .joinToString(separator = "\n") { formatResult(it) }
    }

    private fun formatResult(it: LottoResult): String {
        return "${getRankDescription(it)} (${it.getWinningPrice()}원) - ${it.count}개"
    }

    private fun getRankDescription(it: LottoResult): String {
        return if (it.isSecondRank()) {
            "5개 일치, 보너스 볼 일치"
        } else {
            "${it.getMatchCount()}개 일치"
        }
    }

    fun printProfitRate(computeProfitRate: Double) {
        println(String.format("총 수익률은 %.2f입니다.", floor(computeProfitRate * PERCENT_SCALE) / PERCENT_SCALE))
    }
}
