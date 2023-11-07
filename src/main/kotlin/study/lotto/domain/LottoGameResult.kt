package study.lotto.domain

data class LottoGameResult(
    val statistics: Map<Int, Int>,
    val earningsRate: Double
)
