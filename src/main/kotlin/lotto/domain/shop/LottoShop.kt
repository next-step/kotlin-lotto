package lotto.domain.shop

import math.PositiveNumber

interface LottoShop {

    fun purchase(lottoPurchaseAmount: PositiveNumber): LottoPurchaseResult
}
