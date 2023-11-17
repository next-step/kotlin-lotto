package lotto.domain

data class LottoResult(
    val lottoProfitResult: LottoProfitResult,
    val netSpent: Int,
) {
    val profitRate: Double get() = lottoProfitResult.profitRate
}
