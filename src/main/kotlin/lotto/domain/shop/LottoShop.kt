package lotto.domain.shop

import common.PositiveNumber

interface LottoShop {

    fun purchase(lottoPurchaseAmount: PositiveNumber): LottoPurchaseResult
}
