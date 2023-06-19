package lotto.dto

import lotto.domain.LottoRank

data class ResultDTO(
    val matchNum: Int,
    val lottoRank: LottoRank
)
