package lotto.domain

class LottoResult(purchasedLotteries: PurchasedLotteries, winningLottery: Lottery) {

    private val winningStatistics: Map<LottoRank, Int> = purchasedLotteries.map(winningLottery::correctNumberCount)
        .map(LottoRank::valueOf)
        .groupingBy { it }
        .eachCount()

    private val proceeds: Double = winningStatistics.map { (lottoRank, count) ->
        lottoRank.winningMoney * count.toDouble()
    }.sum()

    val revenue: Revenue = Revenue(proceeds = proceeds, purchasedPrice = purchasedLotteries.purchasedPrice)
    val benefitType: BenefitType = BenefitType.valueOf(rateOfReturn = revenue.rateOfReturn)

    fun countNumberOfHit(lottoRank: LottoRank): Int = winningStatistics[lottoRank] ?: DEFAULT_NUMBER_OF_HIT

    companion object {
        private const val DEFAULT_NUMBER_OF_HIT: Int = 0
    }
}
