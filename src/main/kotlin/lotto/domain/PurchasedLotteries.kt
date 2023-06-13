package lotto.domain

data class PurchasedLotteries(private val lotteries: List<Lottery>) : List<Lottery> by lotteries
