package lotto.domain

class LottoResult(private val winningLotto: WinningLotto, private val lottos: List<Lotto>) {

    fun result(): Map<LottoPrize, Int> {
        return lottos.map { winningLotto.calculateLottoPrize(it) }
            .filter { it != LottoPrize.WHACK }
            .groupingBy { it }
            .eachCount()
    }
}
