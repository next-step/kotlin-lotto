package lotto

class WinningPrizes(val prizes: List<LottoResult.Prize> = emptyList()) {
    private val prizeEachCountMap = prizes.groupingBy { it.name }.eachCount()

    val prizeResult = LottoResult.Prize.values().filter { it.price > 0 }
        .map { Pair(it, prizeEachCountMap.getOrDefault(it.name, 0)) }
}
