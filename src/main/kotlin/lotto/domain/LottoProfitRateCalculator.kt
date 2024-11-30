package lotto.domain

object LottoProfitRateCalculator {
    fun calculate(userLottos: UserLottos, lottoResults: LottoResults): Double {
        val purchaseAmount = userLottos.calculatePurchaseAmount()
        val prizeAmount = lottoResults.calculateTotalPrizeAmount()
        return (prizeAmount / purchaseAmount.toDouble())
    }
}