package lotto.domain

data class LottoResult(
    val lottoPrize: LottoPrize,
    val matchedLottoCount: PositiveNumber
)
