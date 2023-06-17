package lotto.domain

@JvmInline
value class PurchasedLotteries(private val lotteries: List<Lottery>) : List<Lottery> by lotteries {

    fun calculatePurchasedPrice(): Double = sumOf { LotteryAdaptor.LOTTERY_PRICE }

    operator fun plus(other: PurchasedLotteries): PurchasedLotteries = PurchasedLotteries(
        lotteries = this.lotteries + other.lotteries
    )
}
