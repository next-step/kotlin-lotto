package lotto.dto

import lotto.domain.LottoEnum

data class ResultDTO(
    val matchNum: Int,
    val lottoEnum: LottoEnum
)
