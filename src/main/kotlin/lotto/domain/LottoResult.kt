package lotto.domain

data class LottoResult(
    val lottoProfitResult: LottoProfitResult,
) {
    val profitRate: Double get() = lottoProfitResult.profitRate
}
