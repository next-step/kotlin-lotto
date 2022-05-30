package lotto

import kotlin.math.floor

data class WinningPrizes(val prizes: List<LottoPrize> = emptyList()) {
    private val prizeEachCountMap = prizes.groupingBy { it.name }.eachCount()

    val prizeResult = LottoPrize.values().filter { it.price > 0 }
        .map { Pair(it, prizeEachCountMap.getOrDefault(it.name, 0)) }

    fun earnings(purchaseMoney: PurchaseMoney): Double {
        val total = prizes.sumOf { it.price }
        return floor(total.toDouble() / purchaseMoney.money.toDouble() * 100) / 100
    }
}
