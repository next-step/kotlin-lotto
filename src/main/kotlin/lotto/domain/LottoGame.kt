package lotto.domain

class LottoGame(private val winning: WinningLotto) {

    constructor(
        winningNumber: List<Int>,
        bonusNumber: Int
    ) : this(WinningLotto(Lotto(winningNumber.map { LottoNumber.of(it) }), LottoNumber.of(bonusNumber)))

    fun match(lottos: List<Lotto>): LottoResultSummary {
        return LottoResultSummary(lottos.map { match(it) })
    }

    private fun match(lotto: Lotto): LottoResult {
        return winning.match(lotto)
    }
}
