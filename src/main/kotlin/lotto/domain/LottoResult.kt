package lotto.domain

class LottoResult(purchasedLotteries: PurchasedLotteries, winningLottery: Lottery) {

    private val winningStatistics: Map<LottoRank, Int> = purchasedLotteries.map(winningLottery::correctNumberCount)
        .map(LottoRank::valueOf)
        .groupingBy { it }
        .eachCount()

    private val proceeds: Double = winningStatistics.map { (lottoRank, count) ->
        lottoRank.winningMoney * count.toDouble()
    }.sum()

    val rateOfReturn: Double = when {
        proceeds <= ZERO_RATE || purchasedLotteries.purchasedPrice <= ZERO_RATE -> ZERO_RATE
        else -> proceeds / purchasedLotteries.purchasedPrice
    }

    val benefitType: BenefitType = BenefitType.valueOf(rateOfReturn = rateOfReturn)

    fun countNumberOfHit(lottoRank: LottoRank): Int = winningStatistics[lottoRank] ?: DEFAULT_NUMBER_OF_HIT

    companion object {
        private const val DEFAULT_NUMBER_OF_HIT: Int = 0
        private const val ZERO_RATE: Double = 0.0
    }
}
