package lotto.domain.shop

import math.PositiveNumber

data class LottoPurchasePaper(
    val lottoPurchaseAmount: PositiveNumber,
    val selfSettingLottoNumbersPapers: List<SelfSettingLottoNumberPaper>,
)
