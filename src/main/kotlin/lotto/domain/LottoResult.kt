package lotto.domain

class LottoResult(
    val matchResult: MatchResult,
    val payment: LottoPayment,
) {
    val returnOnInvestment: Double
        get() = matchResult.totalPrize.toDouble() / payment.doubleValue()
}
