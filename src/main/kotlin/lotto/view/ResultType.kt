package lotto.view

enum class ResultType(val message: String) {
    PURCHASE_COUNT("%d개를 구매했습니다."),
    PROFIT_RATE("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
}

enum class LottoResult(val message: String, val matchCount: Int, val winningMoney: Int) {
    THREE_MATCH("3개 일치 (5000원) - %d개", 3, 5000),
    FOUR_MATCH("4개 일치 (50000원) - %d개", 4, 50000),
    FIVE_MATCH("5개 일치 (1500000원) - %d개", 5, 1500000),
    SIX_MATCH("6개 일치 (2000000000원) - %d개", 6, 2000000000),
    ;

    companion object {
        fun findByMatchCount(matchCount: Int): LottoResult? {
            return LottoResult.values().find { it.matchCount == matchCount }
        }
    }
}
