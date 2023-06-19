package lottery.domain.lottery

data class PurchasedLotteriesResult(
    val manualCount: Int,
    val randomCount: Int,
    val purchasedAllLotteries: List<Lottery>
)
