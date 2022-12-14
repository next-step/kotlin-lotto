package lotto.domain.lotto.result

import lotto.domain.lotto.benefit.LottoBenefit

data class LottoResult(
    val lottoBenefit: LottoBenefit,
    val lottoResultMap: LottoResultMap
)
