package lotto.domain

class LottoProfitRate(
    total: Int,
    buyingPrice: LottoPrice,
    val profitRate: Double = total / buyingPrice.value.toDouble()
)
