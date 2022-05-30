package lotto.domain

data class Profit(
    val priceGroupedLotteries: Map<Price, Lotteries>,
    val earningRate: Float
)
