package lotto.domain

interface LottoShop {

    fun purchase(lottoPurchaseAmount: Int): LottoPurchaseResult
}
