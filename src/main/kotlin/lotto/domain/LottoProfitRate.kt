package lotto.domain

class LottoProfitRate(
    total: Int,
    buyingPrice: LottoPrice,
    val value: Double = total / buyingPrice.value.toDouble()
)