package lotto.domain

data class Purchase(
    val lottoBundle: LottoBundle,
    val changes: Money
)
