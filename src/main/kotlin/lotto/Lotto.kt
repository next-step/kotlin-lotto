package lotto

data class Lotto(
    val numbers: List<Int>,
    val winning: LottoWinning = LottoWinning.Nothing,
)
