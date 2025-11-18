package domain

data class WinningResult(
    val result: Map<LottoWinningType, Int>,
    val profit: Double,
)
