package lotto

data class WinningPrizes(val prizes: List<LottoPrize> = emptyList()) {
    private val prizeEachCountMap = prizes.groupingBy { it.name }.eachCount()

    val prizeResult = LottoPrize.values().filter { it.price > 0 }
        .map { Pair(it, prizeEachCountMap.getOrDefault(it.name, 0)) }
}
