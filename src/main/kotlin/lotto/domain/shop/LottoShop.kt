package lotto.domain.shop

interface LottoShop {

    fun purchase(lottoPurchaseAmount: Int): LottoPurchaseResult
}
