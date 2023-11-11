package lotto.domain

@JvmInline
value class LottoResult(
    val rankCounts: Map<LottoRank, Int>
)
