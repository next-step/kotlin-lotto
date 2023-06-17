package lotto.dto

import lotto.domain.Lotto

data class LottoBundle(
    val inputMoney: Int,
    val lottoBundle: List<Lotto>
)
