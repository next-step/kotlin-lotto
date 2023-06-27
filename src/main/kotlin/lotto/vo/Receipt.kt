package lotto.vo

import lotto.domain.Lottos

data class Receipt(
    val budget: Int,
    val lottos: Lottos,
    val autoAmount: Int,
    val manualAmount: Int
)
