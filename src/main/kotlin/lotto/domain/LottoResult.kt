package lotto.domain

class LottoResult(private val lottoList: List<Lotto>, private val winningLotto: WinningLotto) {
    val prizeCount = LottoPrize.values().associateWith { 0 }.toMutableMap()

    init {
        lottoList.forEach { lotto ->
            val (matchCount, hasBonus) = lotto.match(winningLotto)
            val lottoPrize = LottoPrize.of(matchCount, hasBonus)
            prizeCount[lottoPrize] = prizeCount.getOrDefault(lottoPrize, 0) + 1
        }
    }

    fun calculateYield(): Double {
        return prizeCount.map { it.key.prizeMoney * it.value }.sum().toDouble() / (Lotto.LOTTO_PRICE * lottoList.size)
    }
}
