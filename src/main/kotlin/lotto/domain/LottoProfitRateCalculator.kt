package lotto.domain

object LottoProfitRateCalculator {
    fun calculate(lottos: Lottos, lottoResults: LottoResults): Double {
        val purchaseAmount = lottos.calculatePurchaseAmount()
        val prizeAmount = lottoResults.calculateTotalPrizeAmount()
        return (prizeAmount / purchaseAmount).toDouble()
    }
}