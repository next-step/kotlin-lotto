package lotto.domain.selling

import lotto.domain.lotto.LottoType

data class Payment(
    val money: Int,
    val lottoType: LottoType = LottoType.AUTO
)
