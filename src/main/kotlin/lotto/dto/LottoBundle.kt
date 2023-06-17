package lotto.dto

import lotto.Lotto

data class LottoBundle(
    val inputMoney: Int,
    val lottoBundle: List<Lotto>
)
