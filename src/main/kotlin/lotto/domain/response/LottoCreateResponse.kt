package lotto.domain.response

import lotto.domain.Lottos

data class LottoCreateResponse(
    val lottos: Lottos,
    val manualCount: Int,
    val autoCount: Int
)
