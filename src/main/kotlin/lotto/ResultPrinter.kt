package lotto

class ResultPrinter(private val lottoResult: LottoGame.Result) {
    fun print() {
        println(
            """
            당첨 통계
            ---------
            """.trimIndent()
        )
        val entries = lottoResult.entries()
        enumValues<Ranking.Rank>()
            .filterNot { it == Ranking.Rank.MISS }
            .forEach { rank ->
                println("${rank.matchCount}개 일치 (${rank.amount}원)- ${entries[rank] ?: 0}개")
            }

        println("총 수익률은 ${lottoResult.profit()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
