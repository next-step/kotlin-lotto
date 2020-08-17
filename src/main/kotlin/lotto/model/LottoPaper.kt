package lotto.model

import lotto.model.Money.Companion.calculateRate

data class LottoPaper(private val lottos: List<Lotto>) {
    val lottoInPaper = mutableListOf<Lotto>()
    val wins = mutableListOf<Win>()

    init {
        this.lottoInPaper.addAll(lottos)
    }

    fun getLottoCount(): Int {
        return lottoInPaper.size
    }

    fun add(addedLottos: List<Lotto>): LottoPaper {
        this.lottoInPaper.addAll(addedLottos)
        return this
    }

    fun checkLottoWin(winner: WinnerLotto) {
        lottoInPaper.forEach { wins.add(it.checkWin(winner)) }
    }

    fun calculate(): Double {
        return calculateRate(wins.map { it })
    }
}
