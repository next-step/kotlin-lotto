package lotto.domain.shop

interface LottoShop {

    fun purchase(lottoPurchasePaper: LottoPurchasePaper): LottoPurchaseResult
}
