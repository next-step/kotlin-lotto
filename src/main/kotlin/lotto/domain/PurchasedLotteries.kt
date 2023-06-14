package lotto.domain

@JvmInline
value class PurchasedLotteries(private val lotteries: List<Lottery>) : List<Lottery> by lotteries {

    fun calculatePurchasedPrice(): Double = sumOf { Lottery.LOTTERY_PRICE }
}
