package lotto.domain

data class Lotto(
    val numbers: List<Int>,
    val winning: LottoWinning = LottoWinning.Nothing,
)
