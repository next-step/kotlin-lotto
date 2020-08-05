package lotto.domain.selling

import lotto.domain.LottoType

data class Payment(
    val money: Int,
    private val lottoType: LottoType = LottoType.AUTO
)
