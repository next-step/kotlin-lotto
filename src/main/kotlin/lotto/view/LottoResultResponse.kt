package lotto.view

data class LottoResultResponse(
    val matchCounts: List<Int>,
    var profit: Double
)
