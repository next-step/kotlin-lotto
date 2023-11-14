package lotto.domain

class LottoResult(private val lottoList: List<Lotto>, private val winningLotto: WinningLotto) {
    private val prizeCount: MutableMap<LottoPrize, Int> = LottoPrize.values().associateWith { 0 }.toMutableMap()

    init {
        lottoList.forEach { lotto ->
            val (matchCount, hasBonus) = winningLotto.match(lotto.numbers)
            val lottoPrize = LottoPrize.of(matchCount, hasBonus)
            prizeCount[lottoPrize] = prizeCount.getOrDefault(lottoPrize, 0) + 1
        }
    }

    fun getPrizeBy(prize: LottoPrize): Int = prizeCount[prize] ?: 0

    fun calculateYield(): Double {
        return prizeCount.map { it.key.prizeMoney * it.value }.sum().toDouble() / (Lotto.LOTTO_PRICE * lottoList.size)
    }
}
