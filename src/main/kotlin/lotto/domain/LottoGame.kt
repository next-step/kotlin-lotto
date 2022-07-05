package lotto.domain

class LottoGame(
    private val lottoPaper: LottoPaper,
    private val winningLotto: WinningLotto
) {

    constructor(
        manualLottoPaper: LottoPaper,
        autoLottoPaper: LottoPaper,
        winningLotto: WinningLotto
    ) : this(
        lottoPaper = LottoPaper(manualLottoPaper.lottos + autoLottoPaper.lottos),
        winningLotto = winningLotto
    )

    private val ranks = lottoPaper.lottos.map { winningLotto.rank(it) }

    private val prize = ranks.sumOf { it.prize }

    val profit: Double = prize / (lottoPaper.size * LOTTO_PRICE)

    val result = LottoGameResult(ranks, profit)

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
