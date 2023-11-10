package lotto.result

import lotto.lotto.LottoPrize

data class LottoResult(
    val lottoPrize: LottoPrize,
    val bonusBallMatched: Boolean,
)
