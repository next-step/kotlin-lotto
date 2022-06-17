package lotto.domain

data class LottoGameResult(
    val ranks: List<Rank>,
    val profit: Double
)
