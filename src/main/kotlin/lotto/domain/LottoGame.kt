package lotto.domain

class LottoGame(winningNumber: List<Int>, bonusNumber: Int) {
    private val winning: WinningLotto

    init {
        this.winning = WinningLotto(Lotto(winningNumber.map { LottoNumber.of(it) }), LottoNumber.of(bonusNumber))
    }

    fun match(lottos: List<Lotto>): LottoResultSummary {
        return LottoResultSummary(lottos.map { match(it) })
    }

    private fun match(lotto: Lotto): LottoResult {
        return winning.match(lotto)
    }
}
