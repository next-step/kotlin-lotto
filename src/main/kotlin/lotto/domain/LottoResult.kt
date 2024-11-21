package lotto.domain

data class LottoResult(
    private val rankToCount: Map<Rank, Int>,
)
