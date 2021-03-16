package lotto.domain

class LottoResult(private val winningLotto: WinningLotto, private val lottos: List<Lotto>) {

    fun result(): List<LottoPrize> {
        return lottos.map { winningLotto.calculateLottoPrize(it) }
    }
}
