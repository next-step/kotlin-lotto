package lotto.domain

class LottoGame(private val winning: WinningLotto) {

    constructor(numbers: List<Int>) : this(WinningLotto(Lotto(numbers.map { LottoNumber.of(it) })))

    fun match(lottos: List<Lotto>): LottoResultSummary {
        return LottoResultSummary(lottos.map { match(it) })
    }

    private fun match(lotto: Lotto): LottoResult {
        return winning.match(lotto)
    }
}
