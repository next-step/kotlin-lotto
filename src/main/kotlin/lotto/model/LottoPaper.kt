package lotto.model

import lotto.model.Money.Companion.calculateRate

data class LottoPaper(private val lottos: List<Lotto>) {
    val lottoInPaper = mutableListOf<Lotto>()

    init {
        this.lottoInPaper.addAll(lottos)
    }

    fun getLottoCount(): Int {
        return lottoInPaper.size
    }

    fun add(newLottos: LottoPaper): LottoPaper {
        this.lottoInPaper.addAll(newLottos.lottos)
        return this
    }

    fun checkLottoWin(winner: WinnerLotto) {
        lottoInPaper.forEach { it.checkWin(winner) }
    }

    fun calculate(): Double {
        return calculateRate(lottoInPaper.map { it.win })
    }
}
