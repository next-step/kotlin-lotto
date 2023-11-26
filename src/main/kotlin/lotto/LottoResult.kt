package lotto

data class LottoResult(
    val matchResult: LottoMatchResult,
    val count: Int,
)

enum class LottoMatchResult(val message: String, val matchCount: Int, val winningMoney: Int) {
    THREE_MATCH("3개 일치 (5000원) - %d개", 3, 5000),
    FOUR_MATCH("4개 일치 (50000원) - %d개", 4, 50000),
    FIVE_MATCH("5개 일치 (1500000원) - %d개", 5, 1500000),
    SIX_MATCH("6개 일치 (2000000000원) - %d개", 6, 2000000000),
    ;

    companion object {
        fun findByMatchCount(matchCount: Int): LottoMatchResult? {
            return LottoMatchResult.values().find { it.matchCount == matchCount }
        }
    }
}